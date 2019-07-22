package com.example.springresttest.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Segment {
	
	@JsonProperty("arrival")
	private Date arrival = new Date();
	
	@JsonProperty("thread")
	private ThreadOfFlyghts threadOfFlyghts;
	
	@JsonProperty("departure")
	private Date departure;
	
	@JsonProperty("terminal")
	private String terminal;
	
	@JsonProperty("platform")
	private String platform;
	
	public Segment() {
		this.threadOfFlyghts = new ThreadOfFlyghts();
		this.arrival = new Date();
	}

	public Segment(Date arrival, ThreadOfFlyghts threadOfFlyghts, Date departure, String terminal, String platform) {
		super();
		this.arrival = arrival;
		this.threadOfFlyghts = threadOfFlyghts;
		this.departure = departure;
		this.terminal = terminal;
		this.platform = platform;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public ThreadOfFlyghts getThreadOfFlyghts() {
		return threadOfFlyghts;
	}

	public void setThreadOfFlyghts(ThreadOfFlyghts threadOfFlyghts) {
		this.threadOfFlyghts = threadOfFlyghts;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "Segment [arrival=" + arrival + ", threadOfFlyghts=" + threadOfFlyghts + ", departure=" + departure
				+ ", terminal=" + terminal + ", platform=" + platform + "]";
	}
	
}
