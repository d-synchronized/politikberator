package com.incedo.politikberator.policy.db.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.politikberator.common.api.constant.ApiConstant;
import com.incedo.politikberator.common.dto.Policy;
import com.incedo.politikberator.policy.db.service.facade.PolicyPersistenceFacade;

import io.swagger.annotations.Api;

@Api("Policy Persistence Controller : Operations to manage policy details")
@RestController
@RequestMapping(ApiConstant.POLICY_DB_SERVICE_CONTROLLER_BASE_PATH)
public class PolicyPersistenceController {

	@Autowired
	private PolicyPersistenceFacade policyPersistenceFacade;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/policy/{policyNumber}")
	public Policy fetchPolicyDetails(@PathVariable("policyNumber") final String policyNumber) {
		final Policy policy =  policyPersistenceFacade.fetchPossiblePolicies(policyNumber);
		return policy;
	}

}
