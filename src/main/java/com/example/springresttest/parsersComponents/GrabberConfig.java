package com.example.springresttest.parsersComponents;

import org.springframework.stereotype.Component;

@Component
public class GrabberConfig {
	
	private String target = "yandex.rasp";
	
	private String siteUri = "https://api.rasp.yandex.net/v3.0/";
	
	private Integer periodicly = 1;
	
	public String getTarget() {
		return this.target;
	}
	
	public String getSiteUri() {
		return this.siteUri;
	}
	
	public Integer getPeriodicly() {
		return this.periodicly;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public void setSiteUri(String siteUri) {
		this.siteUri = siteUri;
	}
	
	public void setPeriodicly(Integer periodicly) {
		this.periodicly = periodicly;
	}
}
