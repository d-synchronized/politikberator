package com.threaddynamics.politlberator.rule.engine.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MappingConfiguration {

	@Bean
	public DozerBeanMapperFactoryBean producesDozerMapperFactoryBean(@Value("classpath*:mapping/dozer-policy-db-configuration.xml") Resource[] resources) {
		final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
		dozerBeanMapperFactoryBean.setMappingFiles(resources);
		return dozerBeanMapperFactoryBean;
	}

}
