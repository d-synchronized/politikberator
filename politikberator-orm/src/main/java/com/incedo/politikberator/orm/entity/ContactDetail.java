package com.incedo.politikberator.orm.entity;

public class ContactDetail {
	
	private Long contactDetailId;
	
	private String telephone;
	
	private String mobile;
	
	private String fax;
	
	private String primaryEmailAddress;
	
	private String secondaryEmailAddress;

	public Long getContactDetailId() {
		return contactDetailId;
	}

	public void setContactDetailId(Long contactDetailId) {
		this.contactDetailId = contactDetailId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPrimaryEmailAddress() {
		return primaryEmailAddress;
	}

	public void setPrimaryEmailAddress(String primaryEmailAddress) {
		this.primaryEmailAddress = primaryEmailAddress;
	}

	public String getSecondaryEmailAddress() {
		return secondaryEmailAddress;
	}

	public void setSecondaryEmailAddress(String secondaryEmailAddress) {
		this.secondaryEmailAddress = secondaryEmailAddress;
	}

}
