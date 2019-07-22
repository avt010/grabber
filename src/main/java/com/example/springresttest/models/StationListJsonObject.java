package com.example.springresttest.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationListJsonObject {
	
	@JsonProperty("countries")
	private List<Country> countrys = new ArrayList<Country>();
	
	public StationListJsonObject() {
		
	}

	public StationListJsonObject(List<Country> countrys) {
		super();
		this.countrys = countrys;
	}

	public List<Country> getCountrys() {
		return countrys;
	}

	public void setCountrys(List<Country> countrys) {
		this.countrys = countrys;
	}

	@Override
	public String toString() {
		return "StationListJsonObject [countrys=" + countrys + "]";
	}
	
	
}
