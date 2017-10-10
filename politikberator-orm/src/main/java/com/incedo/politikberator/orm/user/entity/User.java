package com.incedo.politikberator.orm.user.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.incedo.politikberator.common.constant.BloodGroupType;
import com.incedo.politikberator.orm.address.entity.Address;
import com.incedo.politikberator.orm.advisor.entity.AdvisoryEnquiry;
import com.incedo.politikberator.orm.entity.ContactDetail;
import com.incedo.politikberator.orm.entity.Occupation;

@Entity
@Table(name = "user",schema = "politikberator")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "user_contact_detail",
	           joinColumns = @JoinColumn(name = "user_id"),
	           inverseJoinColumns = @JoinColumn(name = "contact_detail_id",
	           nullable = false)
	)
	private List<ContactDetail> contactDetails;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "user_address_detail",
	           joinColumns = @JoinColumn(name = "user_id"),
	           inverseJoinColumns = @JoinColumn(name = "address_id")
	)
	private List<Address> addresses;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "occupation_id",nullable = false)
	private Occupation occupation;

	@Enumerated(EnumType.STRING)
	@Column(name = "blood_group_type")
	private BloodGroupType bloodGroupType;

	@Column(name = "is_smoker")
	private boolean smoker;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
	private List<AdvisoryEnquiry> advisoryEnquiries;

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

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<AdvisoryEnquiry> getAdvisoryEnquiries() {
		return advisoryEnquiries;
	}

	public void setAdvisoryEnquiries(List<AdvisoryEnquiry> advisoryEnquiries) {
		this.advisoryEnquiries = advisoryEnquiries;
	}

	public List<ContactDetail> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

}
