package com.incedo.politikberator.policy.service.controller;

import static com.incedo.politikberator.common.api.constant.ApiConstant.API_BASE_URI;
import static com.incedo.politikberator.common.api.constant.ApiConstant.API_VERSION;
import static com.incedo.politikberator.common.api.constant.ApiConstant.POLICY_SERVICE_CONTROLLER_BASE_PATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.politikberator.common.dto.AdvisoryEnquiry;
import com.incedo.politikberator.policy.service.facade.PolicyServiceFacade;
import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryResponse;

import io.swagger.annotations.Api;;

@RestController
@RequestMapping(API_BASE_URI + API_VERSION + POLICY_SERVICE_CONTROLLER_BASE_PATH)
@Api("Policy Services : Controller for policy services")
public class PolicyServiceController {
	
	@Autowired
	private PolicyServiceFacade policyServiceFacade;
	
	@ResponseBody
	@RequestMapping("/details/{enquiryNumber}")
	public ResponseEntity<AdvisoryResponse> fetchPolicyDetails(@PathVariable(name = "enquiryNumber") final AdvisoryEnquiry advisoryEnquiry){
		final AdvisoryResponse advisoryResponse = policyServiceFacade.fetchPolicyDetails(advisoryEnquiry);
		if(advisoryResponse == null){
			final ResponseEntity<AdvisoryResponse> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return responseEntity;
		}
		final ResponseEntity<AdvisoryResponse> responseEntity = new ResponseEntity<AdvisoryResponse>(advisoryResponse, HttpStatus.OK);
		return responseEntity;
	}

}
