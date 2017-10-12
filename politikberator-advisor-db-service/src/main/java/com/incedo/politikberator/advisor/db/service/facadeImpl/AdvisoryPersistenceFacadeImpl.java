package com.incedo.politikberator.advisor.db.service.facadeImpl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incedo.politikberator.advisor.db.service.data.repository.AdvisoryPersistenceRepository;
import com.incedo.politikberator.advisor.db.service.facade.AdvisoryPersistenceFacade;
import com.incedo.politikberator.common.dto.AdvisoryEnquiry;
@Service
public class AdvisoryPersistenceFacadeImpl implements AdvisoryPersistenceFacade{

	@Autowired
	AdvisoryPersistenceRepository advisoryPersistenceRepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public AdvisoryEnquiry fetchAdvisoryEnquiry(String enquiryNumber) {
		com.incedo.politikberator.orm.advisor.entity.AdvisoryEnquiry advisoryEntityObj=advisoryPersistenceRepository.findByEnquiryNumber(enquiryNumber);
		AdvisoryEnquiry advisoryEnquiry=mapper.map(advisoryEntityObj, AdvisoryEnquiry.class);
		return advisoryEnquiry;
	}

	@Override
	public AdvisoryEnquiry saveAdvisoryEnquiry(AdvisoryEnquiry advisoryEnquiry) {
		com.incedo.politikberator.orm.advisor.entity.AdvisoryEnquiry advisoryEntityObj=mapper.map(advisoryEnquiry, com.incedo.politikberator.orm.advisor.entity.AdvisoryEnquiry.class);
		advisoryEntityObj=advisoryPersistenceRepository.save(advisoryEntityObj);
		advisoryEnquiry.setAdvisoryEnquiryId(advisoryEntityObj.getAdvisoryEnquiryId());
		advisoryEnquiry.setEnquiryNumber(advisoryEntityObj.getEnquiryNumber());
		return advisoryEnquiry;
	}
}
