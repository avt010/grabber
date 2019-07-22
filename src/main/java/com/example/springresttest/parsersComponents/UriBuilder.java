package com.example.springresttest.parsersComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UriBuilder {
	
	@Autowired
	private UriList uriList;

	public UriBuilder() {
		super();
	}

	public UriList getUriList() {
		return uriList;
	}

	public void setUriList(UriList uriList) {
		this.uriList = uriList;
	}
	
}
