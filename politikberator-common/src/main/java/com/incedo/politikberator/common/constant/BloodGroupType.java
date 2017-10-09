package com.incedo.politikberator.common.constant;

public enum BloodGroupType {

	A_PLUS("A+"),

	A_MINUS("A-"),

	B_PLUS("B+"),

	B_MINUS("B-"),

	O_PLUS("O+"),

	O_MINUS("O-"),

	AB_PLUS("AB+"),

	AB_MINUS("AB-");

	private String bloodGroupDescription;

	BloodGroupType(String bloodGroupDescription) {
		this.bloodGroupDescription = bloodGroupDescription;
	}

	public String getBloodGroupDescription() {
		return bloodGroupDescription;
	}

	public void setBloodGroupDescription(String bloodGroupDescription) {
		this.bloodGroupDescription = bloodGroupDescription;
	}

}
