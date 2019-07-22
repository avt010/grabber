package com.example.springresttest.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Interval {	
	
	private String density;
	
	private Date endTime;
	
	private Date beginTime;
	
	public Interval() {
		this.density = "";
		this.endTime = new Date();
		this.beginTime = new Date();
	}
	
	public void setDensity(String density) {
		this.density = density;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	public String getDensity() {
		return this.density;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	
	public Date getBeginTime() {
		return this.beginTime;
	}

	@Override
	public String toString() {
		return "Interval [density=" + density + ", endTime=" + endTime + ", beginTime=" + beginTime + "]";
	}
	
}
