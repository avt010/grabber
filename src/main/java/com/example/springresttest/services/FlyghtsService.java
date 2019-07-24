package com.example.springresttest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.HashMap;

import com.example.springresttest.entity.Flyghts;
import com.example.springresttest.models.Segment;
import com.example.springresttest.models.ThreadOfFlyghts;
import com.example.springresttest.repository.FlyghtsRepository;
import com.example.springresttest.repository.specifications.FlyghtsSpecification;

@Service
public class FlyghtsService {
	
	@Autowired
	private FlyghtsRepository flyghtsRepository;
	
	public Flyghts saveFlyghtAndGet(Segment segment) {
		Flyghts flyght;
		HashMap<String, Object> filter = new HashMap<String, Object>();
		filter.put("numberOfFlyght", segment.getThreadOfFlyghts().getNumber());
		filter.put("dateToDeparture", segment.getDeparture());
		filter.put("dateToArrival", segment.getArrival());
		Optional<Flyghts> flyghtOptional = flyghtsRepository.findOne(FlyghtsSpecification.flyghtsByName(filter));//segment.getThreadOfFlyghts().getNumber(), segment.getDeparture(), segment.getArrival());
		if (flyghtOptional.isPresent()) {
			flyght = flyghtOptional.get();
		} else {
			flyght = new Flyghts();
			flyght.setDateToArrival(segment.getArrival());
			flyght.setDateToDeparture(segment.getDeparture());
			ThreadOfFlyghts thread = segment.getThreadOfFlyghts();
			flyght.setNumberOfFlyght(thread.getNumber());
			flyghtsRepository.save(flyght);
		}
		return flyght;
	}
	
	/*public List<Flyghts> getAllFlyghts(String from, String to, Date dateToDeparture, Date DateToArival, Integer ticket) {
		return flyghtsRepository.findAll();
	}
	
	public List<Flyghts> getAllFlyghts() {
		return flyghtsRepository.findAll();
	}*/
}