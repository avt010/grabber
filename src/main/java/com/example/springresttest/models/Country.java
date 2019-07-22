package com.example.springresttest.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
	
	@JsonProperty("regions")
	private List<Region> regions = new ArrayList<Region>();
	
	@JsonProperty("codes")
	private CodeWrapper codeWrapper;
	
	@JsonProperty("title")
	private String name;
	
	public Country() {
		
	}

	public Country(List<Region> regions, CodeWrapper codeWrapper, String name) {
		super();
		this.regions = regions;
		this.codeWrapper = codeWrapper;
		this.name = name;
	}
	
	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public CodeWrapper getCodeWrapper() {
		return codeWrapper;
	}

	public void setCodeWrapper(CodeWrapper codeWrapper) {
		this.codeWrapper = codeWrapper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [regions=" + regions + ", codeWrapper=" + codeWrapper + ", name=" + name + "]";
	}
	
	
}
