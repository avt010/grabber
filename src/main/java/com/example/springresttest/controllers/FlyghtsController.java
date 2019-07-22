package com.example.springresttest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 
import com.example.springresttest.components.*;
import com.example.springresttest.entity.*;
import com.example.springresttest.repository.*;
import com.example.springresttest.repository.specifications.FlyghtsSpecification;
//import com.example.springresttest.repository.PersonsRepository;
import com.example.springresttest.services.*;

//import com.example.springresttest.services.FlyghtsService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import com.example.springresttest.entity.Flyghts;

@RestController
@RequestMapping("api/v0/flyghts")
public class FlyghtsController {
	
	//@Autowired
	//FlyghtsService flyghtsService;
	
	@Autowired
	PersonsRepository personsRepository;
	
	@Autowired
	PassportsRepository passportsRepository;
	
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
	
	@Autowired
	private AuthorsRepository authorsRepository;
	
	//@Autowired
	//private FlyghtsSpecification flyghtsSpecification;
	
	@Autowired
	private PagesRepository pagesRepository;
	
	@Autowired
	private BooksService booksService;
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Flyghts>> getFlyghts(@PathVariable("id") Long idOfFlyght,
												@RequestParam("from") String from,
												@RequestParam("to") String to,
												@RequestParam("dateToDeparture") Date dateToDeparture,
												@RequestParam("dateToArival") Date dateToArival,
												@RequestParam("ticket") Integer ticket)
	{
		return new ResponseEntity<List<Flyghts>>(flyghtsService.getAllFlyghts(from, to, dateToDeparture, dateToArival, ticket), HttpStatus.OK);
	}*/
	
	/*@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<String> getFlyghts() {
		Book book = new Book();
		booksService.saveBook(book);
		return new ResponseEntity<String>("0", HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Flyghts>> getAllFlyghts(@RequestParam(value = "number", required = false) String number,
														@RequestParam(value = "date", required = false) Date date,
														@RequestParam(value = "to", required = false) String to
													   )  {
		HashMap<String, Object> filter = new HashMap<String, Object>();
		filter.put("numberOfFlyght", number);
		filter.put("dateToDeparture", date);
		//filter.put("to", to);
		return new ResponseEntity<List<Flyghts>>(flyghtsRepository.findAll(FlyghtsSpecification.flyghtsByName(filter)), HttpStatus.OK);
	}
}