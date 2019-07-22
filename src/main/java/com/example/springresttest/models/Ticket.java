package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Ticket {
	
	private String currency;
	
	private Price price;
	
	private String name;

	public Ticket() {
		super();
		this.currency = "";
		this.price = new Price();
		this.name = "";
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ticket [currency=" + currency + ", price=" + price + ", name=" + name + "]";
	}
	
}