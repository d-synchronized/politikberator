package com.threaddynamics.politlberator.rule.engine.api.dto;

import java.util.Date;

public class PolicyPremiumRequest {

	private Date dateOfBirth;

	private boolean smoker;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

}
