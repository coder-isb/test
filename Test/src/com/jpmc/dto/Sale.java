package com.jpmc.dto;

import java.math.BigDecimal;

public class Sale {
	
	BigDecimal price;
	
	String productType;
	
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		if(price.compareTo(BigDecimal.ZERO) < 0)
			this.price = BigDecimal.ZERO;
		else
			this.price = price;
	}

	public Sale(BigDecimal price, String productType, int quantity) {
		super();
		this.price = price;
		this.productType = productType;
		this.quantity = quantity;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	int quantity;
}
