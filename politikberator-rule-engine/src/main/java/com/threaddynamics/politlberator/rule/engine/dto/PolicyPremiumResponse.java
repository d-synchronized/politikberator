package com.threaddynamics.politlberator.rule.engine.dto;

import com.incedo.politikberator.common.constant.PaymentMode;
import com.incedo.politikberator.common.constant.PolicyPaymentFrequency;

public class PolicyPremiumResponse {

	private String policyNumber;

	private String policyName;

	private String description;

	private boolean eligibleForPolicy;

	private Double premium;

	private Double sumInsuredOnMaturity;

	private Double sumInsuredOnDeath;

	private Double annualPremium;

	private PolicyPaymentFrequency policyPaymentFrequency;

	private PaymentMode[] paymentModes;

	private String message;

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public boolean isEligibleForPolicy() {
		return eligibleForPolicy;
	}

	public void setEligibleForPolicy(boolean eligibleForPolicy) {
		this.eligibleForPolicy = eligibleForPolicy;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public Double getSumInsuredOnMaturity() {
		return sumInsuredOnMaturity;
	}

	public void setSumInsuredOnMaturity(Double sumInsuredOnMaturity) {
		this.sumInsuredOnMaturity = sumInsuredOnMaturity;
	}

	public Double getSumInsuredOnDeath() {
		return sumInsuredOnDeath;
	}

	public void setSumInsuredOnDeath(Double sumInsuredOnDeath) {
		this.sumInsuredOnDeath = sumInsuredOnDeath;
	}

	public Double getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(Double annualPremium) {
		this.annualPremium = annualPremium;
	}

	public PolicyPaymentFrequency getPolicyPaymentFrequency() {
		return policyPaymentFrequency;
	}

	public void setPolicyPaymentFrequency(PolicyPaymentFrequency policyPaymentFrequency) {
		this.policyPaymentFrequency = policyPaymentFrequency;
	}

	public PaymentMode[] getPaymentModes() {
		return paymentModes;
	}

	public void setPaymentModes(PaymentMode[] paymentModes) {
		this.paymentModes = paymentModes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
