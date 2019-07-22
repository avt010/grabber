package com.example.springresttest.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {
	
	@JsonProperty("settlements")
	private List<Settlement> settlements = new ArrayList<Settlement>();
	
	@JsonProperty("codes")
	private CodeWrapper codeWrapper;
	
	@JsonProperty("title")
	private String name;
	
	public Region() {
		
	}
	
	public Region(List<Settlement> settlements, CodeWrapper codeWrapper, String name) {
		super();
		this.settlements = settlements;
		this.codeWrapper = codeWrapper;
		this.name = name;
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

	public List<Settlement> getSettlements() {
		return settlements;
	}

	public void setSettlements(List<Settlement> settlements) {
		this.settlements = settlements;
	}

	@Override
	public String toString() {
		return "Region [settlements=" + settlements + ", codeWrapper=" + codeWrapper + ", name=" + name + "]";
	}
}
