package com.incedo.politikberator.advisor.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.incedo.politikberator.*")
@EnableEurekaClient
public class AdvisoryServiceApplication {
	public static void main(String args[])
	{
		SpringApplication.run(AdvisoryServiceApplication.class,args);
	}
}
