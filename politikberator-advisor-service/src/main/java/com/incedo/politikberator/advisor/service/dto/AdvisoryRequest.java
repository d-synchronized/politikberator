package com.incedo.politikberator.advisor.service.dto;

import java.util.Date;

import com.incedo.politikberator.common.constant.BloodGroupType;

public class AdvisoryRequest {

	private String userFirstName;

	private String userLastName;

	private String emailAddress;

	private Date dateOfBirth;

	private Long cityId;

	private Long stateId;

	private Double coverAmount;

	private BloodGroupType bloodGroupType;

	private boolean smoker;

	private Double annualIncome;

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Double getCoverAmount() {
		return coverAmount;
	}

	public void setCoverAmount(Double coverAmount) {
		this.coverAmount = coverAmount;
	}

	public BloodGroupType getBloodGroupType() {
		return bloodGroupType;
	}

	public void setBloodGroupType(BloodGroupType bloodGroupType) {
		this.bloodGroupType = bloodGroupType;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

}
