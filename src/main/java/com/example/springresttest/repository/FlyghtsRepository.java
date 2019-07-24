package com.example.springresttest.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.springresttest.entity.Flyghts;


@Repository
public interface FlyghtsRepository extends CrudRepository<Flyghts, Long>, JpaSpecificationExecutor<Flyghts>{
	
	//List<Flyghts> findAll();

	//Optional<Flyghts> findByNumberOfFlyghtAndDateToDepartureAndDateToArrival(String numberOfFlyght, Date dateToDeparture, Date dateToArrival);
	
	//List<Flyghts> findAllByCriteria(Specification<Flyghts> spec);
}