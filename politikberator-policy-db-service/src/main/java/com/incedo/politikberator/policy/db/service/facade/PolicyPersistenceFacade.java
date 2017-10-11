package com.incedo.politikberator.policy.db.service.facade;

import java.util.List;

import com.incedo.politikberator.common.dto.Policy;

public interface PolicyPersistenceFacade {

	List<Policy> fetchPossiblePolicies(String enquiryNumber);

}
