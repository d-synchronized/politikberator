package com.threaddynamics.politlberator.rule.engine;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleEngineServiceImpl implements RuleEngineService{
	
	@Autowired
	private KieContainer kieContainer;
	

}
