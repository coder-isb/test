package com.jpmc.dto;

import java.math.BigDecimal;

public class Message {

	private Sale sale;
	private int numberOfSales;
	private char operation;
	private BigDecimal operationValue;
	private MessageType type;

	public Message(Sale sale, MessageType type) {
		this.type = type;
		this.sale = sale;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public int getNumberOfSales() {
		return numberOfSales;
	}

	public void setNumberOfSales(int numberOfSales) {
		this.numberOfSales = numberOfSales;
	}

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	public BigDecimal getOperationValue() {
		return operationValue;
	}

	public void setOperationValue(BigDecimal operationValue) {
		this.operationValue = operationValue;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

}
