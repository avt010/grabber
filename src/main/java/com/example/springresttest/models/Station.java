package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
	
	private String code;
	
	private String title;
	
	@JsonProperty("station_type")
	private String stationType;
	
	@JsonProperty("popular_title")
	private String popularTitle;
	
	@JsonProperty("short_title")
	private String shortTitle;
	
	@JsonProperty("transport_type")
	private String transportType;
	
	@JsonProperty("station_type_name")
	private String stationTypeName;
	
	private String type;
	
	public Station() {
		
	}
	
	public Station(String code, String title, String popularTitle, String shortTitle, String transportType, String type, String stationType, String stationTypeName) {
		this.code = code;
		this.title = title;
		this.popularTitle = popularTitle;
		this.shortTitle = shortTitle;
		this.transportType = transportType;
		this.type = type;
		this.stationType = stationType;
		this.stationTypeName = stationTypeName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getPopularTitle() {
		return popularTitle;
	}

	public void setPopularTitle(String popularTitle) {
		this.popularTitle = popularTitle;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getStationTypeName() {
		return stationTypeName;
	}

	public void setStationTypeName(String stationTypeName) {
		this.stationTypeName = stationTypeName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Station [code=" + code + ", title=" + title + ", stationType=" + stationType + ", popularTitle="
				+ popularTitle + ", shortTitle=" + shortTitle + ", transportType=" + transportType
				+ ", stationTypeName=" + stationTypeName + ", type=" + type + "]";
	}
	
}
