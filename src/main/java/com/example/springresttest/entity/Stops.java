package com.example.springresttest.entity;


import javax.persistence.*;

@Entity
@Table(name = "stops")
public class Stops {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stops_sequence")
	@SequenceGenerator(name = "stops_sequence", sequenceName = "stops_sequence", allocationSize = 0)
	@Column(name = "id_of_stop")
	private Long idOfStop;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_of_thread")
	private Threads thread;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_of_station")
	private Stations station;
	
	@Column(name = "status")
	private Integer status;
	
	public void setIdOfStop(Long idOfStop) {
		this.idOfStop = idOfStop;
	}
	
	public Long getIdOfStop() {
		return this.idOfStop;
	}
	
	public Stations getStation() {
		return station;
	}

	public void setStation(Stations station) {
		this.station = station;
	}

	public Threads getThread() {
		return thread;
	}

	public void setThread(Threads thread) {
		this.thread = thread;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}
}