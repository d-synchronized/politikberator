package com.threaddynamics.politlberator.rule.engine.dto;

import java.util.Date;

import com.incedo.politikberator.common.constant.PaymentMode;
import com.incedo.politikberator.common.constant.PolicyPaymentFrequency;

public class PolicyPremiumRequest {
	
	private Date dateOfBirth;
	
	private boolean smoker;
	
	private String policyName;
	
	private boolean eligibleForPolicy;
	
	private Double premium;
	
	private Double sumInsuredOnMaturity;
	
	private Double sumInsuredOnDeath;
	
	private Double annualPremium;
	
	private PolicyPaymentFrequency policyPaymentFrequency;
	
	private PaymentMode[] paymentModes;
	
	private String message;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
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

	public boolean isEligibleForPolicy() {
		return eligibleForPolicy;
	}

	public void setEligibleForPolicy(boolean eligibleForPolicy) {
		this.eligibleForPolicy = eligibleForPolicy;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

}
