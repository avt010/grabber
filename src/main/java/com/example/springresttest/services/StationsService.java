package com.example.springresttest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springresttest.entity.CategorysOfStation;
import com.example.springresttest.entity.CategorysOfTransport;
import com.example.springresttest.entity.Stations;
import com.example.springresttest.models.Station;
import com.example.springresttest.repository.CategorysOfStationRepository;
import com.example.springresttest.repository.CategorysOfTransportRepository;
import com.example.springresttest.repository.StationsRepository;

@Service
public class StationsService {
	
	@Autowired
	private StationsRepository stationsRepository;
	
	@Autowired
	private CategorysOfStationRepository categorysOfStationRepository;
	
	@Autowired
	private CategorysOfTransportRepository categorysOfTransportRepository;
	
	@Transactional
	public Stations saveOrUpdateAndGet(Station stationJson) {
		Stations station;
		Optional<Stations> stationOptional;
		stationOptional = stationsRepository.findByCode(stationJson.getCode());
		if (stationOptional.isPresent()) {
			station = stationOptional.get();
		} else {
			station = new Stations();
			station.setCode(stationJson.getCode());
			station.setPopularTitle(stationJson.getPopularTitle());
			station.setShortTitle(stationJson.getShortTitle());
			station.setTitle(stationJson.getTitle());
			CategorysOfStation categoryOfStation;
			Optional<CategorysOfStation> categoryOfStationOptional;
			categoryOfStationOptional = categorysOfStationRepository.findByName(stationJson.getStationType());
			if (categoryOfStationOptional.isPresent()) {
				categoryOfStation = categoryOfStationOptional.get();
			} else {
				categoryOfStation = new CategorysOfStation();
				categoryOfStation.setName(stationJson.getStationType());
				categorysOfStationRepository.save(categoryOfStation);
			}
			categoryOfStation.addStation(station);
			station.setCategoryOfStation(categoryOfStation);
			//categorysOfStationRepository.save(categoryOfStation);
			//station.setCategoryOfStation(stationJson.getStationType() == null ? null : categorysOfStationService.saveOrUpdateByName(stationJson.getStationType()));
			CategorysOfTransport categoryOfTransport;
			Optional<CategorysOfTransport> categoryOfTransportOptional;
			categoryOfTransportOptional = categorysOfTransportRepository.findByName(stationJson.getTransportType());
			if (categoryOfTransportOptional.isPresent()) {
				categoryOfTransport = categoryOfTransportOptional.get();
			} else {
				categoryOfTransport = new CategorysOfTransport();
				categoryOfTransport.setName(stationJson.getTransportType());
				categorysOfTransportRepository.save(categoryOfTransport);
			}
			categoryOfTransport.addStation(station);
			station.setCategoryOfTransport(categoryOfTransport);
			//categorysOfTransportRepository.save(categoryOfTransport);
			//station.setCategoryOfTransport(stationJson.getTransportType() == null ? null : categorysOfTransportService.saveOrUpdateByName(stationJson.getTransportType()));
			stationsRepository.save(station);
		}
		return station;
	}
	
}
