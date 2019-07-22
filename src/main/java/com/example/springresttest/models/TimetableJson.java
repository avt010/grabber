package com.example.springresttest.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimetableJson {
	
	@JsonProperty("date")
	private Date date = new Date();
	
	@JsonProperty("pagination")
	private Pagination pagination;
	
	@JsonProperty("station")
	private Station station;
	
	@JsonProperty("schedule")
	private List<Segment> segments = new ArrayList<Segment>();
	
	public TimetableJson() {
		super();
	}

	public TimetableJson(Date date, Pagination pagination, Station station, List<Segment> segments) {
		super();
		this.date = date;
		this.pagination = pagination;
		this.station = station;
		this.segments = segments;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	@Override
	public String toString() {
		return "Timetable [date=" + date + ", pagination=" + pagination + ", station=" + station + ", segments="
				+ segments + "]";
	}
}
