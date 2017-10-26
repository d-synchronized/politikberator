package com.threaddynamics.politlberator.rule.engine.controller;

import static com.incedo.politikberator.common.api.constant.ApiConstant.API_BASE_URI;
import static com.incedo.politikberator.common.api.constant.ApiConstant.API_VERSION;
import static com.incedo.politikberator.common.api.constant.ApiConstant.RULE_ENGINE_CONTROLLER_BASE_PATH;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.threaddynamics.politlberator.rule.engine.RuleEngineService;
import com.threaddynamics.politlberator.rule.engine.api.dto.PolicyPremiumRequest;
import com.threaddynamics.politlberator.rule.engine.api.dto.PolicyPremiumResponse;
import com.threaddynamics.politlberator.rule.engine.exception.RuleEngineException;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(RULE_ENGINE_CONTROLLER_BASE_PATH)
@Api(value = "Rule Engine Resource Endpoints")
public class RuleEngineController {
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private RuleEngineService ruleEngineService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,path="/policy/detail",consumes="application/json",produces="application/json")
	public PolicyPremiumResponse obtainPolicyPremiumDetails(@RequestBody final PolicyPremiumRequest policyPremiumRequest) throws RuleEngineException{
		final com.threaddynamics.politlberator.rule.engine.dto.PolicyPremiumResponse policyPremiumResponseDto = ruleEngineService.obtainPolicyDetails(policyPremiumRequest.getDateOfBirth(), policyPremiumRequest.isSmoker());
		final PolicyPremiumResponse policyPremiumResponse = mapper.map(policyPremiumResponseDto, PolicyPremiumResponse.class);
		return policyPremiumResponse;
	}

}
