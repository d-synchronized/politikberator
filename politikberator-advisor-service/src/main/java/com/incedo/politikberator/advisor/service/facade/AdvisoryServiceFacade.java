package com.incedo.politikberator.advisor.service.facade;

import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryRequest;
import com.threaddynamics.politlberator.rule.engine.api.dto.AdvisoryResponse;

public interface AdvisoryServiceFacade {

	AdvisoryResponse submitAdvisoryRequest(AdvisoryRequest advisory);

}
