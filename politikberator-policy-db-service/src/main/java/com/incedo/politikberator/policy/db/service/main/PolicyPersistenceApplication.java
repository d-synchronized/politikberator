package com.incedo.politikberator.policy.db.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.incedo.politikberator.policy.db.service.data.repository.*")
@EntityScan(basePackages = "com.incedo.politikberator.orm.*")
public class PolicyPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyPersistenceApplication.class, args);
	}

}
