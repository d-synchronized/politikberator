package com.threaddynamics.politlberator.rule.engine.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.threaddynamics.*")
public class RuleEngineApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RuleEngineApplication.class, args);
	}

}
