package com.example.springresttest.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persons_sequence")
	@SequenceGenerator(name = "persons_sequence", sequenceName = "persons_sequence", allocationSize = 0)
	@Column(name = "id_of_person")
	private Long idOfPerson;
	
	@Column(name = "name_of_person")
	private String nameOfPerson;
	
	@OneToOne
	@JoinColumn(name = "id_of_passport")
	@JsonManagedReference
	private Passport passport;

	public Person() {
		
	}

	public Long getIdOfPerson() {
		return idOfPerson;
	}

	public void setIdOfPerson(Long idOfPerson) {
		this.idOfPerson = idOfPerson;
	}
	
	public String getNameOfPerson() {
		return nameOfPerson;
	}

	public void setNameOfPerson(String nameOfPerson) {
		this.nameOfPerson = nameOfPerson;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	
	
}