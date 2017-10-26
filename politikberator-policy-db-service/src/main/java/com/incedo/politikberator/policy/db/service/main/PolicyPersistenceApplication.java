package com.incedo.politikberator.policy.db.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.incedo.*"})
@EnableJpaRepositories(basePackages = "com.incedo.politikberator.policy.db.service.data.repository")
@EntityScan(basePackages = "com.incedo.politikberator.orm.*")
@EnableEurekaClient
public class PolicyPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyPersistenceApplication.class, args);
	}

}
