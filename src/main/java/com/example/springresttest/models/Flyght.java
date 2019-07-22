package com.example.springresttest.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

import com.example.springresttest.components.Periodicly;

@JsonAutoDetect
public class Flyght {
	
private Long idOfFlyght;
	
	private Long numberOfFlyght;
	
	private Long timeToPath;
	
	private Date dateToDeparture;
	
	private Date dateToArival;
	
	private Periodicly periodicly;
	
	public void setIdOfFlyght(Long idOfFlyght) {
		this.idOfFlyght = idOfFlyght;
	}
	
	public void setNumberOfFlyght(Long numberOfFlyght) {
		this.numberOfFlyght = numberOfFlyght;
	}
	
	public void setTimeToPath(Long timeToPath) {
		this.timeToPath = timeToPath;
	}
	
	public void setDateofDeparture(Date dateToDeparture) {
		this.dateToDeparture = dateToDeparture;
	}
	
	public void setDateToArival(Date dateToArival) {
		this.dateToArival = dateToArival;
	}
	
	public void setPeriodicly(Periodicly periodicly) {
		this.periodicly = periodicly;
	}
	
	public Long getIdOfFlyght() {
		return this.idOfFlyght;
	}
	
	public Long getNumberOfFlyght() {
		return this.numberOfFlyght;
	}
	
	public Long getTimeToPath() {
		return this.timeToPath;
	}
	
	public Date getDateToDeparture() {
		return this.dateToDeparture;
	}
	
	public Date getDateToArival() {
		return this.dateToArival;
	}
	
	public Periodicly getPeriodicly() {
		return this.periodicly;
	}

	@Override
	public String toString() {
		return "Flyght [idOfFlyght=" + idOfFlyght + ", numberOfFlyght=" + numberOfFlyght + ", timeToPath=" + timeToPath
				+ ", dateToDeparture=" + dateToDeparture + ", dateToArival=" + dateToArival + ", periodicly="
				+ periodicly + "]";
	}
	
}
