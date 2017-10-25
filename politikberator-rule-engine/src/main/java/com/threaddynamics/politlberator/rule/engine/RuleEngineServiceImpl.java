package com.threaddynamics.politlberator.rule.engine;

import java.util.Date;

import org.dozer.Mapper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threaddynamics.politlberator.rule.engine.dto.PolicyPremiumDetail;
import com.threaddynamics.politlberator.rule.engine.dto.PolicyPremiumResponse;
import com.threaddynamics.politlberator.rule.engine.exception.RuleEngineException;

@Service
public class RuleEngineServiceImpl implements RuleEngineService {

	@Autowired
	private KieContainer kieContainer;

	@Autowired
	private Mapper beanMapper;

	private KieSession prepareStatefulSession() {
		return kieContainer.newKieSession("politikberator-rule-session");
	}

	@Override
	public PolicyPremiumResponse obtainPolicyDetails(final Date dateOfBirth, final boolean isSmoker) throws RuleEngineException {
		final PolicyPremiumDetail policyPremiumDetail = new PolicyPremiumDetail();
		policyPremiumDetail.setDateOfBirth(dateOfBirth);
		policyPremiumDetail.setSmoker(isSmoker);

		final KieSession kieSession = prepareStatefulSession();
		try {
			kieSession.insert(policyPremiumDetail);
			kieSession.fireAllRules();
		} catch (final Exception exception) {
			throw new RuleEngineException("Error occurred while obtaining the policy premium details against dateOfBirth '" + dateOfBirth
							+ "' and isSmoker '" + isSmoker + "', Error ",exception);
		} finally {
			kieSession.dispose();
		}
		return beanMapper.map(policyPremiumDetail, PolicyPremiumResponse.class);
	}

}
