package com.incedo.politikberator.advisor.db.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.incedo.politikberator.orm.*")
@SpringBootApplication(scanBasePackages = "com.incedo.politikberator.*")
public class AdvisoryPersistenceApplication {
	public static void main(String args[])
	{
		SpringApplication.run(AdvisoryPersistenceApplication.class,args);
	}
}
