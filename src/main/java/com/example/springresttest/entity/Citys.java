package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "citys")
public class Citys {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citys_sequence")
	@SequenceGenerator(name = "citys_sequence", sequenceName = "citys_sequence", allocationSize =1)
	@Column(name = "id_of_city")
	private Long idOfCity;
	
	@Column(name = "name_of_city")
	private String nameOfCity;
	
	@Column(name = "code")
	private String code;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_region")
	private Regions region;
	
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Stations> stations = new ArrayList<Stations>();
	
	public Citys() {
		
	}
	
	public Citys(Long idOfCity, String nameOfCity, Regions region, List<Stations> stations) {
		super();
		this.idOfCity = idOfCity;
		this.nameOfCity = nameOfCity;
		this.region = region;
		this.stations = stations;
	}
	
	public void setIdOfCity(Long idOfCity) {
		this.idOfCity = idOfCity;
	}
	
	public void setNameOfCity(String nameOfCity) {
		this.nameOfCity = nameOfCity;
	}
	
	public Long getIdOfCity() {
		return this.idOfCity;
	}
	
	public String getNameOfCity() {
		return this.nameOfCity;
	}

	public Regions getRegion() {
		return region;
	}

	public void setRegion(Regions region) {
		this.region = region;
	}

	public List<Stations> getStations() {
		return stations;
	}

	public void setStations(List<Stations> stations) {
		this.stations = stations;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void addStation(Stations station) {
		this.stations.add(station);
	}
	
	public void delStation(Stations station) {
		if (this.stations.contains(station)) {
			this.stations.remove(station);
		}
	}

	@Override
	public String toString() {
		return "Citys [idOfCity=" + idOfCity + ", nameOfCity=" + nameOfCity + ", code=" + code + ", region=" + region
				+ ", stations=" + stations + "]";
	}
}