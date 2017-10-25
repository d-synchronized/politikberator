package com.incedo.politikberator.policy.service.facade;

import com.incedo.politikberator.common.dto.AdvisoryEnquiry;
import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryResponse;

public interface PolicyServiceFacade {

	AdvisoryResponse fetchPolicyDetails(AdvisoryEnquiry advisoryEnquiry);

}
