package com.incedo.politikberator.policy.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.incedo.*")
public class PolicyServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PolicyServiceApplication.class, args);
	}

}
