package com.incedo.politikberator.advisor.service.facadeiImpl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.incedo.politikberator.advisor.service.facade.AdvisoryServiceFacade;
import com.incedo.politikberator.common.api.constant.ApiConstant;
import com.incedo.politikberator.common.dto.Address;
import com.incedo.politikberator.common.dto.AdvisoryEnquiry;
import com.incedo.politikberator.common.dto.ContactDetail;
import com.incedo.politikberator.common.dto.Occupation;
import com.incedo.politikberator.common.dto.User;
import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryRequest;
import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryResponse;

@Service
public class AdvisoryServiceFacadeImpl implements AdvisoryServiceFacade {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public AdvisoryResponse submitAdvisoryRequest(AdvisoryRequest advisory) {
		Address address = new Address();
		List<Address> addList = new ArrayList<Address>();
		addList.add(address);

		ContactDetail contactDetail = new ContactDetail();
		contactDetail.setMobile(advisory.getMobile());
		contactDetail.setTelephone(advisory.getTelephone());
		contactDetail.setFax(advisory.getFax());
		contactDetail.setPrimaryEmailAddress(advisory.getPrimaryEmailAddress());
		contactDetail.setSecondaryEmailAddress(advisory.getSecondaryEmailAddress());
		List<ContactDetail> contactList = new ArrayList<ContactDetail>();
		contactList.add(contactDetail);
		
		Occupation occupation=new Occupation();
		occupation.setOrganization(advisory.getOrganization());
		occupation.setPermanent(advisory.isPermanent());
		occupation.setFromDate(advisory.getFromDate());
		occupation.setToDate(advisory.getToDate());
		occupation.setSalary(advisory.getSalary());
		
		User user = new User();
		user.setFirstName(advisory.getUserFirstName());
		user.setLastName(advisory.getUserLastName());
		user.setAddresses(addList);
		user.setContactDetails(contactList);
		user.setOccupation(occupation);
		user.setDateOfBirth(advisory.getDateOfBirth());
		user.setBloodGroupType(advisory.getBloodGroupType());
		user.setSmoker(advisory.isSmoker());

		AdvisoryEnquiry advisoryEnquiryRequest = new AdvisoryEnquiry();
		advisoryEnquiryRequest.setUser(user);
		advisoryEnquiryRequest.setCoverAmount(advisory.getCoverAmount());
		
		RequestEntity<AdvisoryEnquiry> requestEntity;
		AdvisoryEnquiry advisoryEnquiryResponse=null;
		try {
			requestEntity = RequestEntity.post(new URI(ApiConstant.ADVISOR_DB_SERVICE_BASE_URI+"/saveAdvisoryInquiry")).accept(MediaType.APPLICATION_JSON)
					.body(advisoryEnquiryRequest);
			ResponseEntity<AdvisoryEnquiry> advisoryEnquiryEntityResponse = restTemplate.exchange(requestEntity, AdvisoryEnquiry.class);
			advisoryEnquiryResponse = advisoryEnquiryEntityResponse.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		
		RequestEntity<AdvisoryEnquiry> policyRequestEntity;
		AdvisoryResponse advisoryResponse = null;
		
		try {
			policyRequestEntity = RequestEntity.post(new URI(ApiConstant.POLICY_SERVICE_BASE_URI+"/detail")).accept(MediaType.APPLICATION_JSON)
					.body(advisoryEnquiryResponse);
			ResponseEntity<AdvisoryResponse> response = restTemplate.exchange(policyRequestEntity, AdvisoryResponse.class);
			advisoryResponse = response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return advisoryResponse;
	}
}
