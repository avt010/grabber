package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Price {
	
	private Integer cents;
	
	private Integer whole;

	public Price() {
		super();
		this.cents = this.whole = 0;
	}

	public Integer getCents() {
		return cents;
	}

	public void setCents(Integer cents) {
		this.cents = cents;
	}

	public Integer getWhole() {
		return whole;
	}

	public void setWhole(Integer whole) {
		this.whole = whole;
	}

	@Override
	public String toString() {
		return "Price [cents=" + cents + ", whole=" + whole + "]";
	}
	
}
