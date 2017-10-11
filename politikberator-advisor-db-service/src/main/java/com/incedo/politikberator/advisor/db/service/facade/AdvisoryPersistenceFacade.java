package com.incedo.politikberator.advisor.db.service.facade;

import com.incedo.politikberator.common.dto.AdvisoryEnquiry;

public interface AdvisoryPersistenceFacade {
	public AdvisoryEnquiry fetchAdvisoryEnquiry(String enquiryNumber);
	public AdvisoryEnquiry saveAdvisoryEnquiry(AdvisoryEnquiry advisoryEnquiry);
}
