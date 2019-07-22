package com.example.springresttest.parsersComponents;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springresttest.models.CarrierWrapper;
import com.example.springresttest.models.StopJson;
import com.example.springresttest.models.TimetableJson;

@Component
public class Data {
	
	private List<TimetableJson> timetables = new ArrayList<TimetableJson>();
	
	private List<StopJson> stops = new ArrayList<StopJson>();
	
	private List<CarrierWrapper> carriersWrapper = new ArrayList<CarrierWrapper>();
	
	public Data() {
		
	}

	public Data(List<TimetableJson> timetables, List<StopJson> stops, List<CarrierWrapper> carriersWrapper) {
		super();
		this.timetables = timetables;
		this.stops = stops;
		this.carriersWrapper = carriersWrapper;
	}

	public List<StopJson> getStopsJson() {
		return stops;
	}

	public void setStopsJson(List<StopJson> stops) {
		this.stops = stops;
	}
	
	public void addStopJson(StopJson stopJson) {
		this.stops.add(stopJson);
	}
	
	public void delStopJson(StopJson stopJson) {
		if (this.stops.contains(stopJson)) {
			this.stops.remove(stopJson);
		}
	}

	public List<StopJson> getStops() {
		return stops;
	}

	public void setStops(List<StopJson> stops) {
		this.stops = stops;
	}

	public List<CarrierWrapper> getCarriersWrapper() {
		return carriersWrapper;
	}

	public void setCarriersWrapper(List<CarrierWrapper> carriersWrapper) {
		this.carriersWrapper = carriersWrapper;
	}
	
	public void addCarrierJson(CarrierWrapper carrierJson) {
		this.carriersWrapper.add(carrierJson);
	}
	
	public void delCarrierJson(CarrierWrapper carrierJson) {
		if (this.carriersWrapper.contains(carrierJson)) {
			this.carriersWrapper.remove(carrierJson);
		}
	}

	public List<TimetableJson> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<TimetableJson> timetables) {
		this.timetables = timetables;
	}
	
	public void addTimetable(TimetableJson timetable) {
		this.timetables.add(timetable);
	}
	
	public void delTimetable(TimetableJson timetable) {
		if (this.timetables.contains(timetable)) {
			this.timetables.remove(timetable);
		}
	}

	@Override
	public String toString() {
		return "Data [timetables=" + timetables + ", stops=" + stops + ", carriersWrapper=" + carriersWrapper + "]";
	}
}
