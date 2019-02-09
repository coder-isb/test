package com.jpmc.dto;

import java.math.BigDecimal;

public class SaleAdjustment {

	private Sale sale;
	private BigDecimal amount;
	private char Operation;

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal  amount) {
		this.amount = amount;
	}

	public char getOperation() {
		return Operation;
	}

	public void setOperation(char operation) {
		Operation = operation;
	}

}
