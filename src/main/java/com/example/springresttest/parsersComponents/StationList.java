package com.example.springresttest.parsersComponents;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StationList {
	
	private List<String> stations = new ArrayList<String>();
	
	public StationList() {
		this.stations.add("s9623277");
		this.stations.add("s9605027");
		this.stations.add("s9605089");
		this.stations.add("s9623276");
		this.stations.add("s9761879");
	}

	public StationList(List<String> stations) {
		super();
		this.stations = stations;
	}

	public void setStations(List<String> stations) {
		this.stations = stations;
	}

	public List<String> getStations() {
		return stations;
	}
	
	public void addStation(String station) {
		this.stations.add(station);
	}
	
	public void delStation(String station) {
		if (this.stations.contains(station)) {
			this.stations.remove(station);
		}
	}

	@Override
	public String toString() {
		return "StationList [stations=" + stations + "]";
	}
	
	
}
