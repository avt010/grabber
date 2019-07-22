package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_sequence")
	@SequenceGenerator(name = "countries_sequence", sequenceName = "countries_sequence", allocationSize = 1)
	@Column(name = "id_of_country")
	private Long idOfCountry;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Regions> regions = new ArrayList<Regions>();
	
	public Countries() {
		
	}

	public Countries(Long idOfCountry, String name, List<Regions> regions) {
		super();
		this.idOfCountry = idOfCountry;
		this.name = name;
		this.regions = regions;
	}

	public Long getIdOfCountry() {
		return idOfCountry;
	}

	public void setIdOfCountry(Long idOfCountry) {
		this.idOfCountry = idOfCountry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Regions> getRegions() {
		return regions;
	}

	public void setRegions(List<Regions> regions) {
		this.regions = regions;
	}
	
	public void addRegion(Regions region) {
		this.regions.add(region);
	}
	
	public void delRegion(Regions region) {
		if (this.regions.contains(region)) {
			this.regions.remove(region);
		}
	}

	@Override
	public String toString() {
		return "Countries [idOfCountry=" + idOfCountry + ", name=" + name + ", code=" + code + ", regions=" + regions
				+ "]";
	}
}
