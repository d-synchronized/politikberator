package com.incedo.politikberator.orm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;

public class BaseEntity {

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "modified_at")
	private Date modifiedAt;
	
	@PrePersist
	void prePersist(){
		if(this.createdAt == null){
			this.createdAt = new Date();
		}
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
