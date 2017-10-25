package com.incedo.politikberator.policy.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
	
	@Bean
	public RestTemplate producesRestTemplate(){
		return new RestTemplate();
	}

}
