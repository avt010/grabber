/*package com.example.springresttest.entity;

import javax.persistence.*;

@Entity
@Table(name = "OptionsOfTransport")
public class OptionsOfTransport {
	
	@Id
	@GeneratedValue
	private Long idOptionOfTransport;
	
	@OneToOne(mappedBy = "ClassOfOptionsOfCategoryOfTransport", cascade = CascadeType.ALL)
	private Long idOptionOfCategoryOfTransport;
	
	@OneToOne(mappedBy = "Transport", cascade = CascadeType.ALL)
	private Long idOfTransport;
	
	@Column(name = "value")
	private Integer value;
	
	public void setIdOptionOfTransport(Long idOptionOfTransport) {
		this.idOptionOfTransport = idOptionOfTransport;
	}
	
	public void setIdOptionOfCategoryOfTransport(Long idOptionOfCategoryOfTransport) {
		this.idOptionOfCategoryOfTransport = idOptionOfCategoryOfTransport;
	}
	
	public void setIdOfTransport(Long idOfTransport) {
		this.idOfTransport = idOfTransport;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public Long getIdOptionOfTransport() {
		return this.idOptionOfTransport;
	}
	
	public Long getIdOptionOfCategoryOfTransport() {
		return this.idOptionOfCategoryOfTransport;
	}
	
	public Long getIdOfTransport() {
		return this.idOfTransport;
	}
	
	public Integer getValue() {
		return this.value;
	}
}*/