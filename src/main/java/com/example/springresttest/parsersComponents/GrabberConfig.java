package com.example.springresttest.parsersComponents;

import org.springframework.stereotype.Component;

@Component
public class GrabberConfig {
	
	private String target = "yandex.rasp";
	
	private String siteUri = "https://api.rasp.yandex.net/v3.0/";
	
	
	public String getTarget() {
		return this.target;
	}
	
	public String getSiteUri() {
		return this.siteUri;
	}
	
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public void setSiteUri(String siteUri) {
		this.siteUri = siteUri;
	}
}
