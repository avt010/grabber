package com.example.springresttest.parsersComponents;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UriManager {
	
	@Autowired
	private UriList uriList;
	
	public UriManager() {
		
	}
	
	public void addUri(String name, Uri uri) {
		if (!this.uriList.has(name)) {
			this.uriList.addUri(name, uri);
		} else {
			this.uriList.updateUri(name, uri);
		}
	}
	
	public void delUri(String name, Uri uri) {
		if (this.uriList.has(name)) {
			this.uriList.delUri(name, uri);
		}
	}
	
	public Optional<Uri> findUri(String name, Uri uri) {
		if (this.uriList.has(name)) {
			return Optional.ofNullable(this.uriList.getUri(name));
		} else {
			return Optional.ofNullable(null);
		}
	}
}
