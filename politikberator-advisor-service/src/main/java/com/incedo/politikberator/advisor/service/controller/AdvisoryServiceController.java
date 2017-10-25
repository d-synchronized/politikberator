package com.incedo.politikberator.advisor.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.politikberator.advisor.service.facade.AdvisoryServiceFacade;
import com.incedo.politikberator.common.api.constant.ApiConstant;
import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryRequest;
import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryResponse;

@RestController
@RequestMapping(ApiConstant.API_BASE_URI+ApiConstant.API_VERSION+"/advisory")
public class AdvisoryServiceController {
	
	@Autowired
	AdvisoryServiceFacade advisoryServiceFacade;

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,path="/submitAdvisoryRequest",consumes="application/json",produces="application/json")
	public AdvisoryResponse submitAdvisoryRequest(@RequestBody AdvisoryRequest advisory)
	{
		AdvisoryResponse advisoryResponse=advisoryServiceFacade.submitAdvisoryRequest(advisory);
		return advisoryResponse;
	}
}
