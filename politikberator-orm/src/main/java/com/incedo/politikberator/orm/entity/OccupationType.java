package com.incedo.politikberator.orm.entity;

public class OccupationType {

	private Long occupationTypeId;

	private Long lookupId;

	private String name;

	public Long getOccupationTypeId() {
		return occupationTypeId;
	}

	public void setOccupationTypeId(Long occupationTypeId) {
		this.occupationTypeId = occupationTypeId;
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
