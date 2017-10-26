package com.incedo.politikberator.policy.service.facade;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.incedo.politikberator.common.api.constant.ApiConstant;
import com.incedo.politikberator.common.dto.Policy;
import com.incedo.politikberator.common.dto.AdvisoryEnquiry;
import com.incedo.politikberator.common.dto.User;
import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryResponse;
import com.threaddynamics.politlberator.rule.engine.api.dto.PolicyPremiumRequest;
import com.threaddynamics.politlberator.rule.engine.api.dto.PolicyPremiumResponse;

@Service
public class PolicyServiceFacadeImpl implements PolicyServiceFacade{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public AdvisoryResponse fetchPolicyDetails(AdvisoryEnquiry advisoryEnquiry){
		final User user = advisoryEnquiry.getUser();
		final PolicyPremiumRequest policyPremiumRequest = new PolicyPremiumRequest();
		policyPremiumRequest.setDateOfBirth(user.getDateOfBirth());
		policyPremiumRequest.setSmoker(user.isSmoker());
        
		final PolicyPremiumResponse policyPremiumResponse = fetchPolicyPremiumDetail(policyPremiumRequest);
		final AdvisoryResponse advisoryResponse = new AdvisoryResponse();
		advisoryResponse.setPolicyPremiumResponse(policyPremiumResponse);
		advisoryResponse.setEnquiryNumber(advisoryEnquiry.getEnquiryNumber());
        if(policyPremiumResponse.isEligibleForPolicy()){
        	final Policy policy = fetchPolicyBrief(policyPremiumResponse);
        	advisoryResponse.setProduct(policy.getProduct());
		}
		return advisoryResponse;
	}


	private Policy fetchPolicyBrief(final PolicyPremiumResponse policyPremiumResponse) {
		final URI uri = new UriTemplate(ApiConstant.POLICY_DB_SERVICE_BASE_URI +"/policy/{policyNumber}")
				                                            .expand(policyPremiumResponse.getPolicyNumber());
		final RequestEntity<Void> policyResponseEntity = RequestEntity
				                                            .get(uri)
				                                            .accept(MediaType.APPLICATION_JSON).build();
		final ResponseEntity<Policy> responseEntity = restTemplate.exchange(policyResponseEntity, Policy.class);
		final Policy policy = responseEntity.getBody();
		return policy;
	}


	private PolicyPremiumResponse fetchPolicyPremiumDetail(final PolicyPremiumRequest policyPremiumRequest) {
		RequestEntity<PolicyPremiumRequest> requestEntity = null;
		try {
			requestEntity = RequestEntity
					              .post(new URI(ApiConstant.RULE_ENGINE_SERVICE_BASE_URI + "/policy/detail"))
					              .accept(MediaType.APPLICATION_JSON).body(policyPremiumRequest);
		} catch (URISyntaxException uriSyntaxException) {
			
		}
		final ResponseEntity<PolicyPremiumResponse> response = restTemplate.exchange(requestEntity, PolicyPremiumResponse.class);
		final PolicyPremiumResponse policyPremiumResponse = response.getBody();
		return policyPremiumResponse;
	}

}
