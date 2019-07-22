package com.example.springresttest.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "passports")
public class Passport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passports_sequence")
	@SequenceGenerator(name = "passports_sequence", sequenceName = "passports_sequence", allocationSize = 0)
	@Column(name = "id_of_passport")
	private Long idOfPassport;
	
	@Column(name = "number_of_passport")
	private Integer numberOfPassport;
	
	@OneToOne(mappedBy = "passport")
	@JsonBackReference
	private Person person;
	
	public Passport() {
		
	}

	public Long getIdOfPassport() {
		return idOfPassport;
	}

	public void setIdOfPassport(Long idOfPassport) {
		this.idOfPassport = idOfPassport;
	}

	public Integer getNumberOfPassport() {
		return numberOfPassport;
	}

	public void setNumberOfPassport(Integer numberOfPassport) {
		this.numberOfPassport = numberOfPassport;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}