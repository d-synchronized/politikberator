package com.threaddynamics.politlberator.rule.engine;

import java.util.Date;

import com.threaddynamics.politlberator.rule.engine.dto.PolicyPremiumResponse;
import com.threaddynamics.politlberator.rule.engine.exception.RuleEngineException;

public interface RuleEngineService {

	PolicyPremiumResponse obtainPolicyDetails(Date dateOfBirth, boolean isSmoker) throws RuleEngineException;

}
