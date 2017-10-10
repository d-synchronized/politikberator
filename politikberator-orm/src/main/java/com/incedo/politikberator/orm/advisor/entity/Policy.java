package com.incedo.politikberator.orm.advisor.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "policy",
       schema = "politikberator",
       indexes = @Index(columnList = "policy_nunber" , name = "policy_policy_nunber_idx"))
public class Policy {
	
	@Id
	@Column(name = "policy_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long policyId;
	
	@Column(name = "policy_name",nullable = false)
	private String policyName;
	
	@Column(name = "policy_nunber",nullable = false,unique = true)
	private String policyNumber;
	
	@Column(name = "description",nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id",referencedColumnName = "product_id")
	private Product product;

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
