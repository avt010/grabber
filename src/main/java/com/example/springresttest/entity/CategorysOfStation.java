package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categorys_of_station")
public class CategorysOfStation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorys_of_station_sequence")
	@SequenceGenerator(name = "categorys_of_station_sequence", sequenceName = "categorys_of_station_sequence", allocationSize = 1)
	@Column(name = "id_of_category_of_station")
	private Long idOfCategoryOfStation;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "categoryOfStation", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Stations> stations = new ArrayList<Stations>();
	
	public CategorysOfStation() {
		
	}

	public Long getIdOfCategoryOfStation() {
		return idOfCategoryOfStation;
	}

	public void setIdOfCategoryOfStation(Long idOfCategoryOfStation) {
		this.idOfCategoryOfStation = idOfCategoryOfStation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Stations> getStations() {
		return stations;
	}

	public void setStations(List<Stations> stations) {
		this.stations = stations;
	}
	
	public void addStation(Stations station) {
		this.stations.add(station);
	}
	
	public void delStation(Stations station) {
		if (this.stations.contains(station)) {
			this.stations.remove(station);
		}
	}
}