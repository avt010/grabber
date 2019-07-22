package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationsInfo {
	
	@JsonProperty("station")
	private Station station;
	
	public StationsInfo() {
		
	}

	public StationsInfo(Station station) {
		super();
		this.station = station;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "StationsInfo [station=" + station + "]";
	}
}
