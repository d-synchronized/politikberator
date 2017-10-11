package com.incedo.politikberator.advisor.db.service.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.incedo.politikberator.orm.advisor.entity.AdvisoryEnquiry;

public interface AdvisoryPersistenceRepository extends CrudRepository<AdvisoryEnquiry, Long>{
	AdvisoryEnquiry findByEnquiryNumber(final String enquiryNumber);
}
