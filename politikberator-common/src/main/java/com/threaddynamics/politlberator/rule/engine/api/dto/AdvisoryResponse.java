package com.threaddynamics.politlberator.rule.engine.api.dto;

import com.incedo.politikberator.common.dto.Product;

public class AdvisoryResponse {

	private String enquiryNumber;

	private Product product;

	private PolicyPremiumResponse policyPremiumResponse;

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PolicyPremiumResponse getPolicyPremiumResponse() {
		return policyPremiumResponse;
	}

	public void setPolicyPremiumResponse(PolicyPremiumResponse policyPremiumResponse) {
		this.policyPremiumResponse = policyPremiumResponse;
	}

}
