package com.example.springresttest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 
import com.example.springresttest.entity.*;
import com.example.springresttest.repository.*;
import com.example.springresttest.repository.specifications.FlyghtsSpecification;
import com.example.springresttest.services.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v0/flyghts")
public class FlyghtsController {
	
	@Autowired
	FlyghtsRepository flyghtsRepository;
	
	@Autowired
	StationsRepository stationsRepository;
	
	@Autowired
	TransportsRepository transportsRepository;
	
	@Autowired
	CategorysOfStationRepository categorysOfStationRepository;
	
	@Autowired
	CategorysOfTransportRepository categorysOfTransportRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Flyghts>> getAllFlyghts(@RequestParam(value = "number", required = false) String number,
														@RequestParam(value = "date", required = false) Date date,
														@RequestParam(value = "to", required = false) String to
													   )  {
		HashMap<String, Object> filter = new HashMap<String, Object>();
		filter.put("numberOfFlyght", number);
		filter.put("dateToDeparture", date);
		return new ResponseEntity<List<Flyghts>>(flyghtsRepository.findAll(FlyghtsSpecification.flyghtsByName(filter)), HttpStatus.OK);
	}
}