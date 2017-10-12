package com.incedo.politikberator.advisor.db.service.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.incedo.politikberator.orm.advisor.entity.AdvisoryEnquiry;

@Repository
public interface AdvisoryPersistenceRepository extends CrudRepository<AdvisoryEnquiry, Long>{
	AdvisoryEnquiry findByEnquiryNumber(final String enquiryNumber);
}
