package com.threaddynamics.politlberator.rule.engine.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KieConfig {

	@Bean
	public KieContainer producesKieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

}
