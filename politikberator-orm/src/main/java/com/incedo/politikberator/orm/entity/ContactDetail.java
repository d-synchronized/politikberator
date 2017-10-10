package com.incedo.politikberator.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="contact_detail", 
       schema = "politikberator",
       indexes = @Index(columnList = "primary_email",name = "contact_detail_primary_email_idx"))
public class ContactDetail{
	
	@Id
	@Column(name = "contact_detail_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contactDetailId;
	
	@Column
	private String telephone;
	
	@Column
	private String mobile;
	
	@Column
	private String fax;
	
	@Column(name = "primary_email",nullable = false,unique = true)
	private String primaryEmailAddress;
	
	@Column(name = "secondary_email")
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
