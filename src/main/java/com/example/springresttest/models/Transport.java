package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Transport {
	
	private String color;
	
	private String code;
	
	private String title;
	
	public Transport() {
		this.color = this.code = this.title = "";
	}

	public Transport(String color, String code, String title) {
		super();
		this.color = color;
		this.code = code;
		this.title = title;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Transport [color=" + color + ", code=" + code + ", title=" + title + "]";
	}
	
}
