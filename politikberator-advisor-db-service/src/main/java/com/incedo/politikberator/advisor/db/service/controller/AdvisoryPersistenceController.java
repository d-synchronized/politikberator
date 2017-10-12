package com.incedo.politikberator.advisor.db.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.politikberator.advisor.db.service.facade.AdvisoryPersistenceFacade;
import com.incedo.politikberator.common.api.constant.ApiConstant;
import com.incedo.politikberator.common.dto.AdvisoryEnquiry;

@RestController
@RequestMapping(ApiConstant.API_BASE_URI + ApiConstant.API_VERSION + "/advisoryPersistence")
public class AdvisoryPersistenceController {

	@Autowired
	AdvisoryPersistenceFacade advisoryPersistenceFacade;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, path = "/saveAdvisoryInquiry", consumes = "application/json", produces = "application/json")
	public AdvisoryEnquiry submitAdvisoryRequest(@RequestBody AdvisoryEnquiry advisoryEnquiry) {
		return advisoryPersistenceFacade.saveAdvisoryEnquiry(advisoryEnquiry);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/enquiry/{enquiryNumber}",produces="application/json")
	public AdvisoryEnquiry fetchUserEnquiry(
			@PathVariable(name = "enquiryNumber", required = true) final String enquiryNumber) {
		final AdvisoryEnquiry advisoryEnquiry = advisoryPersistenceFacade.fetchAdvisoryEnquiry(enquiryNumber);
		return advisoryEnquiry;
	}
}
