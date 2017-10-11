package com.incedo.politikberator.advisor.service.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.politikberator.advisor.service.dto.AdvisoryRequest;
import com.incedo.politikberator.advisor.service.dto.AdvisoryResponse;
import com.incedo.politikberator.common.api.constant.ApiConstant;

@RestController
@RequestMapping(ApiConstant.API_BASE_URI+ApiConstant.API_VERSION+"/advisory")
public class AdvisoryServiceController {

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,path="/submitAdvisoryRequest",consumes="application/json",produces="application/json")
	public AdvisoryResponse submitAdvisoryRequest(@RequestBody AdvisoryRequest advisory)
	{
		return null;
	}
}
