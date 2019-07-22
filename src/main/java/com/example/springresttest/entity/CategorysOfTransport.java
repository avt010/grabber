package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categorys_of_transport")
public class CategorysOfTransport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorys_of_transport_sequence")
	@SequenceGenerator(name = "categorys_of_transport_sequence", sequenceName = "categorys_of_transport_sequence", allocationSize = 1)
	@Column(name = "id_of_category_of_transport")
	private Long idOfCategoryOfTransport;
	
	@Column(name = "name_of_category_of_transport")
	private String name;
	
	@OneToMany(mappedBy = "categoryOfTransport", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Transports> transports = new ArrayList<Transports>();
	
	@OneToMany(mappedBy = "categoryOfTransport", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Threads> threads = new ArrayList<Threads>();
	
	@OneToMany(mappedBy = "categoryOfTransport", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Stations> stations = new ArrayList<Stations>();
	
	public CategorysOfTransport() {
		
	}

	public Long getIdOfCategoryOfTransport() {
		return idOfCategoryOfTransport;
	}

	public void setIdOfCategoryOfTransport(Long idOfCategoryOfTransport) {
		this.idOfCategoryOfTransport = idOfCategoryOfTransport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Transports> getTransports() {
		return transports;
	}

	public void setTransports(List<Transports> transports) {
		this.transports = transports;
	}

	public List<Threads> getThreads() {
		return threads;
	}

	public void setThreads(List<Threads> threads) {
		this.threads = threads;
	}

	public List<Stations> getStations() {
		return stations;
	}

	public void setStations(List<Stations> stations) {
		this.stations = stations;
	}

	public void addTransport(Transports transport) {
		this.transports.add(transport);
	}
	
	public void addThread(Threads thread) {
		this.threads.add(thread);
	}
	
	public void addStation(Stations station) {
		this.stations.add(station);
	}
	
	public void delTransport(Transports transport) {
		if (this.transports.contains(transport)) {
			this.transports.remove(transport);
		}
	}
	
	public void delThread(Threads thread) {
		if (this.threads.contains(thread)) {
			this.threads.remove(thread);
		}
	}
	
	public void delStation(Stations station) {
		if (this.stations.contains(station)) {
			this.stations.remove(station);
		}
	}
}