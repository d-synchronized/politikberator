package com.incedo.politikberator.orm.advisor.entity;

import com.incedo.politikberator.orm.entity.BaseEntity;
import com.incedo.politikberator.orm.user.entity.User;

public class AdvisoryEnquiry extends BaseEntity{
	
	private Long advisoryEnquiryId;
	
	private String enquiryNumber;
	
	private User user;
	
	private Double coverAmount;

	public Long getAdvisoryEnquiryId() {
		return advisoryEnquiryId;
	}

	public void setAdvisoryEnquiryId(Long advisoryEnquiryId) {
		this.advisoryEnquiryId = advisoryEnquiryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getCoverAmount() {
		return coverAmount;
	}

	public void setCoverAmount(Double coverAmount) {
		this.coverAmount = coverAmount;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

}
