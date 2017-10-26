package com.incedo.politikberator.user.db.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan("com.incedo.politikberator.orm.*")
@SpringBootApplication(scanBasePackages = "com.incedo.politikberator.*")
public class UserPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPersistenceApplication.class, args);
	}

}
