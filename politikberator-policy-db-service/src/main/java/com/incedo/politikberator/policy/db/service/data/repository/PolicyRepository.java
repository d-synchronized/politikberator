package com.incedo.politikberator.policy.db.service.data.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incedo.politikberator.orm.advisor.entity.Policy;


@Repository
public interface PolicyRepository extends CrudRepository<Policy, Serializable>{
	
	

}
