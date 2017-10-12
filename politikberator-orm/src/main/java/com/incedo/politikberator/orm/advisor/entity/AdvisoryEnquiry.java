package com.incedo.politikberator.orm.advisor.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.incedo.politikberator.orm.entity.BaseEntity;
import com.incedo.politikberator.orm.user.entity.User;

@Entity
@Table(name = "advisory_enquiry",
       schema = "politikberator",
       indexes = @Index(columnList = "enquiry_number",name = "advisory_enquiry_enquiry_number_idx"))
public class AdvisoryEnquiry extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "advisory_enquiry_id")
	private Long advisoryEnquiryId;
	
	@Column(name = "enquiry_number",nullable = false,unique = true)
	private String enquiryNumber;
	
	@ManyToOne(optional = false,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false, updatable=false)
	private User user;
	
	@Column(name = "cover_amount",nullable = false)
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
	
	@PrePersist
	void generateEnquiryNumber()
	{
		if(this.enquiryNumber==null)
		this.enquiryNumber=UUID.randomUUID().toString();
	}
	

}
