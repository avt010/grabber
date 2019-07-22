package com.example.springresttest.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.springresttest.entity.Flyghts;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlyghtsRepository extends CrudRepository<Flyghts, Long>, JpaSpecificationExecutor<Flyghts>{
	
	//List<Flyghts> findAll();

	//Optional<Flyghts> findByNumberOfFlyghtAndDateToDepartureAndDateToArrival(String numberOfFlyght, Date dateToDeparture, Date dateToArrival);
}