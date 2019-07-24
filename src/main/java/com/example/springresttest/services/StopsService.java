package com.example.springresttest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springresttest.entity.CategorysOfStation;
import com.example.springresttest.entity.CategorysOfTransport;
import com.example.springresttest.entity.Stations;
import com.example.springresttest.entity.Stops;
import com.example.springresttest.entity.Threads;
import com.example.springresttest.models.Station;
import com.example.springresttest.models.StationsInfo;
import com.example.springresttest.models.StopJson;
import com.example.springresttest.parsersComponents.Data;
import com.example.springresttest.repository.*;

@Service
public class StopsService {
	
	@Autowired
	private StopsRepository stopsRepository;
	
	@Autowired
	private Data data;
	
	@Autowired
	private ThreadsService threadsService;
	
	@Autowired
	private StationsRepository stationsRepository;
	
	@Autowired
	private CategorysOfStationRepository categorysOfStationRepository;
	
	@Autowired
	private CategorysOfTransportRepository categorysOfTransportRepository;
	
	public void addStop(Stations station, Threads thread, Integer status) {
		Stops stop = new Stops();
		stop.setStation(station);
		stop.setStatus(status);
		stop.setThread(thread);
		stopsRepository.save(stop);
		return;
	}
	
	@Transactional
	public void saveStops() {
		List<StopJson> stopsList = data.getStopsJson();
		for (StopJson stopsJson : stopsList) {
			//System.out.println(stopsJson);
			List<StationsInfo> stops = stopsJson.getStationsInfo();
			for (StationsInfo stopJson : stops) {
				Stops stop = new Stops();
				Integer status = 0;
				Integer index = stops.indexOf(stopJson);
				if (index == 0) status = 1;
				else if (index == stopsJson.getStationsInfo().size() - 1) status = 2;
				else status = 0;
				stop.setStatus(status);
				Threads thread = threadsService.getByUid(stopsJson.getUid());
				stop.setThread(thread);
				Station stationJson = stopJson.getStation();
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
				Optional<Stops> stopOptional = stopsRepository.findByStation_IdOfStationAndThread_IdOfThreadAndStatus(station.getIdOfStation(), thread.getIdOfThread(), status);
				if (stopOptional.isPresent()) continue;
				//Stations station = stationsService.saveOrUpdateAndGet(stopJson.getStation());
				stop.setStation(station);
				thread.addStop(stop);
				station.addStop(stop);
				stopsRepository.save(stop);
			}
		}
		return;
	}

}
