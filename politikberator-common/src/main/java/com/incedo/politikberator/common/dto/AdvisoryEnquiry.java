package com.incedo.politikberator.common.dto;

public class AdvisoryEnquiry extends BaseDto {

	private static final long serialVersionUID = -821156125209075058L;

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

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
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

}
