package com.incedo.politikberator.advisor.db.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.incedo.politikberator.orm.*")
@SpringBootApplication(scanBasePackages = "com.incedo.politikberator.*")
@EnableJpaRepositories(basePackages="com.incedo.politikberator.advisor.db.service.data.repository.*")
public class AdvisoryPersistenceApplication {
	public static void main(String args[])
	{
		SpringApplication.run(AdvisoryPersistenceApplication.class,args);
	}
}
