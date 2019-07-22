package com.example.springresttest.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class TicketInfo {
	
	@JsonProperty("et_marker")
	private Boolean etMarker;
	
	@JsonProperty("places")
	private List<Ticket> ticket;
	
	private Integer duration;
	
	@JsonProperty("arrival_terminal")
	private String arrivalTerminal;
	
	@JsonProperty("start_date")
	private Date startDate;
	
	@JsonProperty("arrival_platform")
	private String arrivalPlatform;

	public TicketInfo() {
		super();
		this.etMarker = false;
		this.ticket = new ArrayList<Ticket>();
		this.startDate = new Date();
	}
	
	public void setEtMarker(Boolean etMarker) {
		this.etMarker = etMarker;
	}
	
	public Boolean getEtMarker() {
		return this.etMarker;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getArrivalTerminal() {
		return arrivalTerminal;
	}

	public void setArrivalTerminal(String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getArrivalPlatform() {
		return arrivalPlatform;
	}

	public void setArrivalPlatform(String arrivalPlatform) {
		this.arrivalPlatform = arrivalPlatform;
	}

	@Override
	public String toString() {
		return "TicketInfo [etMarker=" + etMarker + ", ticket=" + ticket + "]";
	}
	
}
