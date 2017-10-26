package com.incedo.politikberator.common.dto;

import java.util.List;

public class Product extends BaseDto {

	private static final long serialVersionUID = -8600454341845769696L;

	private Long productId;

	private String productNumber;

	private String productName;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
