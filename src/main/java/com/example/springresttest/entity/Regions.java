package com.example.springresttest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Regions {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regions_sequence")
	@SequenceGenerator(name = "regions_sequence", sequenceName = "regions_sequence", allocationSize = 1)
	@Column(name = "id_of_region")
	private Long idOfRegion;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Citys> citys = new ArrayList<Citys>();
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "id_of_country")
	private Countries country;
	
	public Regions() {
		
	}

	public Regions(Long idOfRegion, String name, List<Citys> citys, Countries country) {
		super();
		this.idOfRegion = idOfRegion;
		this.name = name;
		this.citys = citys;
		this.country = country;
	}

	public Long getIdOfRegion() {
		return idOfRegion;
	}

	public void setIdOfRegion(Long idOfRegion) {
		this.idOfRegion = idOfRegion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Citys> getCitys() {
		return citys;
	}

	public void setCitys(List<Citys> citys) {
		this.citys = citys;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void addCity(Citys city) {
		this.citys.add(city);
	}
	
	public void delCity(Citys city) {
		if (this.citys.contains(city)) {
			this.citys.remove(city);
		}
	}
	
	

	@Override
	public String toString() {
		return "Regions [idOfRegion=" + idOfRegion + ", name=" + name + ", code=" + code + ", citys=" + citys
				+ ", country=" + country + "]";
	}
}
