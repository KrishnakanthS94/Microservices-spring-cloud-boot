package com.krrish.microservices.bean;

import java.math.BigDecimal;


public class CurrencyConversionBean {
	private String from;
	private String to;
	private BigDecimal converisonMultiple;
	private Long id;
	private BigDecimal quantity;
	private BigDecimal totalAmount;
	private String port;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConverisonMultiple() {
		return converisonMultiple;
	}
	public void setConverisonMultiple(BigDecimal converisonMultiple) {
		this.converisonMultiple = converisonMultiple;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public CurrencyConversionBean(String from, String to, BigDecimal converisonMultiple, Long id, BigDecimal quantity,
			BigDecimal totalAmount, String port) {
		super();
		this.from = from;
		this.to = to;
		this.converisonMultiple = converisonMultiple;
		this.id = id;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.port = port;
	}
	
	public CurrencyConversionBean() {}
	

}
