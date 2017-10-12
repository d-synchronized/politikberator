package com.incedo.politikberator.common.dto;

import java.util.Date;
import java.util.List;

import com.incedo.politikberator.common.constant.BloodGroupType;

public class User extends BaseDto {

	private static final long serialVersionUID = 1987316430234983682L;

	private Long userId;

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private List<ContactDetail> contactDetails;

	private List<Address> addresses;

	private Occupation occupation;

	private BloodGroupType bloodGroupType;

	private boolean smoker;

	/*private List<AdvisoryEnquiry> advisoryEnquiries;*/

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<ContactDetail> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
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

	/*public List<AdvisoryEnquiry> getAdvisoryEnquiries() {
		return advisoryEnquiries;
	}

	public void setAdvisoryEnquiries(List<AdvisoryEnquiry> advisoryEnquiries) {
		this.advisoryEnquiries = advisoryEnquiries;
	}*/

}
