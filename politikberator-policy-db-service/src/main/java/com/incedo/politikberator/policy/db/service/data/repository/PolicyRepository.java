package com.incedo.politikberator.policy.db.service.data.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.incedo.politikberator.common.dto.Policy;

public interface PolicyRepository extends CrudRepository<Policy, Serializable>{
	
	

}
