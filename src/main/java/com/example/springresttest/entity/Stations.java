package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "stations")
public class Stations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stations_sequence")
	@SequenceGenerator(name = "stations_sequence", sequenceName = "stations_sequence", allocationSize = 1)
	@Column(name = "id_of_station")
	private Long idOfStation;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_category_of_station")
	private CategorysOfStation categoryOfStation;
	
	@Column(name = "popular_title")
	private String popularTitle;
	
	@Column(name = "short_title")
	private String shortTitle;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_category_of_transport")
	private CategorysOfTransport categoryOfTransport;
	
	@OneToMany(mappedBy = "station", fetch = FetchType.LAZY)
	private List<Stops> stops = new ArrayList<Stops>();
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_city")
	private Citys city;
	
	public Stations() {
		
	}

	public Stations(Long idOfStation, String code, String title, CategorysOfStation categoryOfStation,
			String popularTitle, String shortTitle, CategorysOfTransport categoryOfTransport, List<Stops> stops,
			Citys city) {
		super();
		this.idOfStation = idOfStation;
		this.code = code;
		this.title = title;
		this.categoryOfStation = categoryOfStation;
		this.popularTitle = popularTitle;
		this.shortTitle = shortTitle;
		this.categoryOfTransport = categoryOfTransport;
		this.stops = stops;
		this.city = city;
	}

	public Long getIdOfStation() {
		return idOfStation;
	}

	public void setIdOfStation(Long idOfStation) {
		this.idOfStation = idOfStation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategorysOfStation getCategoryOfStation() {
		return categoryOfStation;
	}

	public void setCategoryOfStation(CategorysOfStation categoryOfStation) {
		this.categoryOfStation = categoryOfStation;
	}

	public String getPopularTitle() {
		return popularTitle;
	}

	public void setPopularTitle(String popularTitle) {
		this.popularTitle = popularTitle;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public CategorysOfTransport getCategoryOfTransport() {
		return categoryOfTransport;
	}

	public void setCategoryOfTransport(CategorysOfTransport categoryOfTransport) {
		this.categoryOfTransport = categoryOfTransport;
	}

	public Citys getCity() {
		return city;
	}

	public void setCity(Citys city) {
		this.city = city;
	}

	public List<Stops> getStops() {
		return stops;
	}

	public void setStops(List<Stops> stops) {
		this.stops = stops;
	}
	
	public void addStop(Stops stop) {
		this.stops.add(stop);
	}
	
	public void delStop(Stops stop) {
		if (this.stops.contains(stop)) {
			this.stops.remove(stop);
		}
	}

	@Override
	public String toString() {
		return "Stations [idOfStation=" + idOfStation + ", code=" + code + ", title=" + title + ", categoryOfStation="
				+ categoryOfStation + ", popularTitle=" + popularTitle + ", shortTitle=" + shortTitle
				+ ", categoryOfTransport=" + categoryOfTransport + ", stops=" + stops + ", city=" + city + "]";
	}
}