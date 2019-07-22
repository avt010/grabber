package com.example.springresttest.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Settlement {
	
	@JsonProperty("stations")
	private List<Station> stations = new ArrayList<Station>();
	
	@JsonProperty("codes")
	private CodeWrapper codeWrapper;
	
	@JsonProperty("title")
	private String name;
	
	public Settlement() {
		
	}

	public Settlement(List<Station> stations, CodeWrapper codeWrapper, String name) {
		super();
		this.stations = stations;
		this.codeWrapper = codeWrapper;
		this.name = name;
	}
	
	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
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
		return "Settlement [stations=" + stations + ", codeWrapper=" + codeWrapper + ", name=" + name + "]";
	}
	
	
}
