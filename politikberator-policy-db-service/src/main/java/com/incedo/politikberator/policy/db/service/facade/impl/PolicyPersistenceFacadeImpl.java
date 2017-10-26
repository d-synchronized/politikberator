package com.incedo.politikberator.policy.db.service.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incedo.politikberator.common.dto.Policy;
import com.incedo.politikberator.common.dto.Product;
import com.incedo.politikberator.policy.db.service.data.repository.PolicyRepository;
import com.incedo.politikberator.policy.db.service.facade.PolicyPersistenceFacade;

@Service
public class PolicyPersistenceFacadeImpl implements PolicyPersistenceFacade {

	@Autowired
	private Mapper mapper;

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Policy fetchPossiblePolicies(final String enquiryNumber) {
		final Product product = new Product();
		product.setProductId(1L);
		product.setProductName("LIC");
		product.setProductNumber("C001-INS-LIC");

		final Policy policy = new Policy();
		policy.setPolicyNumber("LICCORP1234");
		policy.setPolicyName("LIC Corporate 5 Yearly Plan");
		policy.setDescription("LIC Corporate - GOLD Customer BEEMA");
		policy.setPolicyId(1L);
		policy.setProduct(product);
		return policy;
	}

}
