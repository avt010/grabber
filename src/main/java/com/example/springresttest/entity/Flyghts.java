package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "flyghts")
public class Flyghts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flyghts_sequence")
	@SequenceGenerator(name = "flyghts_sequence", sequenceName = "flyghts_sequence", allocationSize = 1)
	@Column(name = "id_of_flyght")
	private Long idOfFlyght;
	
	@Column(name = "number_of_flyght")
	private String numberOfFlyght;
	
	@Column(name = "time_to_path")
	private Double timeToPath;
	
	@Column(name = "date_to_departure")
	private Date dateToDeparture;
	
	@Column(name = "date_to_arrival")
	private Date dateToArrival;
	
	@OneToMany(mappedBy = "flyght", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Timetables> timetables = new ArrayList<Timetables>();
	
	public Flyghts() {
		
	}
	
	public void setIdOfFlyght(Long idOfFlyght) {
		this.idOfFlyght = idOfFlyght;
	}
	
	public void setNumberOfFlyght(String numberOfFlyght) {
		this.numberOfFlyght = numberOfFlyght;
	}
	
	public void setTimeToPath(Double timeToPath) {
		this.timeToPath = timeToPath;
	}
	
	public void setDateToDeparture(Date dateToDeparture) {
		this.dateToDeparture = dateToDeparture;
	}
	
	public void setDateToArrival(Date dateToArrival) {
		this.dateToArrival = dateToArrival;
	}
	
	public Long getIdOfFlyght() {
		return this.idOfFlyght;
	}
	
	public String getNumberOfFlyght() {
		return this.numberOfFlyght;
	}
	
	public Double getTimeToPath() {
		return this.timeToPath;
	}
	
	public Date getDateToDeparture() {
		return this.dateToDeparture;
	}
	
	public Date getDateToArrival() {
		return this.dateToArrival;
	}

	public List<Timetables> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<Timetables> timetables) {
		this.timetables = timetables;
	}
	
	public void addTimetable(Timetables timetable) {
		this.timetables.add(timetable);
	}
	
	public void delTimetable(Timetables timetable) {
		if (this.timetables.contains(timetable)) {
			this.timetables.remove(timetable);
		}
	}

	@Override
	public String toString() {
		return "Flyghts [idOfFlyght=" + idOfFlyght + ", numberOfFlyght=" + numberOfFlyght + ", timeToPath=" + timeToPath
				+ ", dateToDeparture=" + dateToDeparture + ", dateToArrival=" + dateToArrival + "]";
	}
	
}