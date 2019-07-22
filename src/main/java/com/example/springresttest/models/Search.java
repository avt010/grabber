package com.example.springresttest.models;

import java.util.Date;

public class Search {
	
	private Date date;
	
	private Station to;
	
	private Station from;

	public Search() {
		super();
		this.date = new Date();
		this.to = new Station();
		this.from = new Station();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Station getTo() {
		return to;
	}

	public void setTo(Station to) {
		this.to = to;
	}

	public Station getFrom() {
		return from;
	}

	public void setFrom(Station from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "Search [date=" + date + ", to=" + to + ", from=" + from + "]";
	}
	
}
