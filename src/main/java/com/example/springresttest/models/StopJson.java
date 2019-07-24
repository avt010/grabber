package com.example.springresttest.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class StopJson {
	
	@JsonProperty("uid")
	private String uid;
	
	@JsonProperty("stops")
	private List<StationsInfo> stationsInfo = new ArrayList<StationsInfo>();
	
	public StopJson() {
		
	}

	public StopJson(String uid, List<StationsInfo> stationsInfo) {
		super();
		this.uid = uid;
		this.stationsInfo = stationsInfo;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<StationsInfo> getStationsInfo() {
		return stationsInfo;
	}

	public void setStationsInfo(List<StationsInfo> stationsInfo) {
		this.stationsInfo = stationsInfo;
	}
	
	
	@Override
	public String toString() {
		return "StopJson [uid=" + uid + ", stops=" + stationsInfo + "]";
	}
}
