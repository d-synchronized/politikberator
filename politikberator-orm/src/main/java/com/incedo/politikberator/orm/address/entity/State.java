package com.incedo.politikberator.orm.address.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "state",
       schema = "politikberator",
       indexes = @Index(columnList = "lookup_id" , name = "state_lookup_id_idx"))
public class State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "state_id	")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stateId;

	@Column(name = "lookup_id",nullable = false)
	private Long lookupId;

	@Column(name = "name",nullable = false)
	private String name;

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getLookupId() {
		return lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
