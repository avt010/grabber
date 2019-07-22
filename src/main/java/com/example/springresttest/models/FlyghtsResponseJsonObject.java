package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlyghtsResponseJsonObject {
	
	@JsonProperty("interval_segments")
	private List<Segment> intervalSegments;
	
	private Pagination pagination;
	
	private List<Segment> segments;
	
	private Search search;
	
	public FlyghtsResponseJsonObject() {
		this.intervalSegments = new ArrayList<Segment>();
		this.pagination = new Pagination();
		this.segments = new ArrayList<Segment>();
		this.search = new Search();
	}
	
	public void setIntervalSegments(List<Segment> intervalSegments) {
		this.intervalSegments = intervalSegments;
	}
	
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
	
	public List<Segment> getIntervalSegments() {
		return this.intervalSegments;
	}
	
	public Pagination getPagination() {
		return this.pagination;
	}
	
	public List<Segment> getSegments() {
		return this.segments;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}
	
	@Override
	public String toString() {
		return "FlyghtsResponseJsonObject [intervalSegments=" + intervalSegments + ", pagination=" + pagination
				+ ", segments=" + segments + ", search=" + search + "]";
	}
}
