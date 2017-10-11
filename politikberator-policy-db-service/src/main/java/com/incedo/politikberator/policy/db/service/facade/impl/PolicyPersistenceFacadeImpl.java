package com.incedo.politikberator.policy.db.service.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incedo.politikberator.common.dto.Policy;
import com.incedo.politikberator.common.dto.Product;
import com.incedo.politikberator.policy.db.service.facade.PolicyPersistenceFacade;
import com.incedo.politikberator.policy.db.service.repository.PolicyRepository;

@Service
public class PolicyPersistenceFacadeImpl implements PolicyPersistenceFacade {

	@Autowired
	private Mapper mapper;

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public List<Policy> fetchPossiblePolicies(final String enquiryNumber) {
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

		final List<Policy> policies = new ArrayList<>();
		policies.add(policy);
		product.setPolicies(policies);
		return policies;
	}

}
