package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Carrier {
	
	private String code;
	
	private String contacts;
	
	private String url;
	
	@JsonProperty("logo_svg")
	private String logoSvg;
	
	private String title;
	
	private String phone;
	
	private Codes codes = new Codes();
	
	private String address;
	
	private String logo;
	
	private String email;
	
	public Carrier() {
		this.code = this.contacts = this.url = this.logoSvg = this.title = this.phone = this.address = this.logo = this.email = "";
		this.codes = new Codes();
	}

	public Carrier(String code, String contacts, String url, String logoSvg, String title, String phone, Codes codes,
			String address, String logo, String email) {
		super();
		this.code = code;
		this.contacts = contacts;
		this.url = url;
		this.logoSvg = logoSvg;
		this.title = title;
		this.phone = phone;
		this.codes = codes;
		this.address = address;
		this.logo = logo;
		this.email = email;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogoSvg() {
		return this.logoSvg;
	}

	public void setLogoSvg(String logoSvg) {
		this.logoSvg = logoSvg;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Codes getCodes() {
		return this.codes;
	}

	public void setCodes(Codes codes) {
		this.codes = codes;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Carrier [code=" + code + ", contacts=" + contacts + ", url=" + url + ", logoSvg=" + logoSvg + ", title="
				+ title + ", phone=" + phone + ", codes=" + codes + ", address=" + address + ", logo=" + logo
				+ ", email=" + email + "]";
	}
	
}
