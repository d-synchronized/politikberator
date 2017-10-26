package com.incedo.politikberator.policy.db.service.facade;

import com.incedo.politikberator.common.dto.Policy;

public interface PolicyPersistenceFacade {

	Policy fetchPossiblePolicies(String enquiryNumber);

}
