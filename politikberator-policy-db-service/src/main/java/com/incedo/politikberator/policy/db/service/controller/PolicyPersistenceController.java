package com.incedo.politikberator.policy.db.service.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.politikberator.common.api.constant.ApiConstant;
import com.incedo.politikberator.common.dto.Policy;
import com.incedo.politikberator.policy.db.service.facade.PolicyPersistenceFacade;

@RestController
@RequestMapping(ApiConstant.API_BASE_URI + ApiConstant.API_VERSION + "/policy")
public class PolicyPersistenceController {

	@Autowired
	private PolicyPersistenceFacade policyPersistenceFacade;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/policy/{policyNumber}")
	public List<Policy> fetchPolicyDetails(@PathVariable("policyNumber") final String policyNumber) {
		final List<Policy> policies = policyPersistenceFacade.fetchPossiblePolicies(policyNumber);
		if (policies == null || policies.isEmpty()) {
			return Collections.emptyList();
		}
		return policies;
	}

}
