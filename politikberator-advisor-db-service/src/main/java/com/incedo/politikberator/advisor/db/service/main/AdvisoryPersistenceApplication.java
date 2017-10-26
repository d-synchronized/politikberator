package com.incedo.politikberator.advisor.db.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.incedo.politikberator.*")
@EntityScan(basePackages="com.incedo.politikberator.orm.*")
@EnableJpaRepositories(basePackages="com.incedo.politikberator.*")
@EnableTransactionManagement
@EnableEurekaClient
public class AdvisoryPersistenceApplication {
	public static void main(String args[])
	{
		SpringApplication.run(AdvisoryPersistenceApplication.class,args);
	}
}
