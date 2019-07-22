/*package com.example.springresttest.components;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.springresttest.entity.CategorysOfStation;
import com.example.springresttest.entity.CategorysOfTransport;
import com.example.springresttest.entity.Citys;
import com.example.springresttest.entity.Countries;
import com.example.springresttest.entity.Regions;
import com.example.springresttest.entity.Stations;
import com.example.springresttest.entity.SubCategorysOfTransport;
import com.example.springresttest.models.Country;
import com.example.springresttest.models.Region;
import com.example.springresttest.models.Settlement;
import com.example.springresttest.models.Station;
import com.example.springresttest.models.StationListJsonObject;
import com.example.springresttest.models.StopJson;
import com.example.springresttest.parsersComponents.Data;
import com.example.springresttest.parsersComponents.UriList;
import com.example.springresttest.repository.CategorysOfStationRepository;
import com.example.springresttest.repository.CategorysOfTransportRepository;
import com.example.springresttest.repository.CitysRepository;
import com.example.springresttest.repository.CountriesRepository;
import com.example.springresttest.repository.RegionsRepository;
import com.example.springresttest.repository.StationsRepository;
import com.example.springresttest.repository.SubCategorysOfTransportRepository;

@Component
public class StationInitialization implements ApplicationRunner {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private UriList uriList;
	
	@Autowired
	private Data data;
	
	@Autowired
	private CountriesRepository countriesRepository;
	
	@Autowired
	private RegionsRepository regionsRepository;
	
	@Autowired
	private StationsRepository stationsRepository;
	
	@Autowired
	private CitysRepository citysRepository;
	
	@Autowired
	private CategorysOfStationRepository categorysOfStationRepository;
	
	@Autowired
	private CategorysOfTransportRepository categorysOfTransportRepository;
	
	@Autowired
	private SubCategorysOfTransportRepository subCategorysOfTransportRepository;
	
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		try {
			StationListJsonObject stationListJsonObject = restTemplate.getForObject(uriList.getUri("station").getUriAsString(), StationListJsonObject.class);
			Countries country = new Countries();
			for (Country countryJson : stationListJsonObject.getCountrys()) {
				country = new Countries();
				if (countryJson.getCodeWrapper() != null && countryJson.getCodeWrapper().getCode() != null) {
					Optional<Countries> countryOptional = countriesRepository.findByCode(countryJson.getCodeWrapper().getCode());
					if (countryOptional.isPresent()) {
						country = countryOptional.get();
					} else {
						country.setCode(countryJson.getCodeWrapper().getCode());
						country.setName(countryJson.getName());
						System.out.println(country);
						countriesRepository.save(country);
					}
				}
				if (countryJson.getCodeWrapper() == null || countryJson.getCodeWrapper().getCode() == null || !countryJson.getName().equals("Россия")) {
					continue;
				} else {
					List<Region> regionsJson = countryJson.getRegions();
					for (Region regionJson :regionsJson) {
						Regions region = new Regions();
						//System.out.println(regionJson.toString());
						if (regionJson.getCodeWrapper() != null && regionJson.getCodeWrapper().getCode() != null && regionJson.getName().equals("Белгородская область")) {
							Optional<Regions> regionOptional = regionsRepository.findByCode(regionJson.getCodeWrapper().getCode());
							if (regionOptional.isPresent()) {
								region = regionOptional.get();
							} else {
								region.setCode(regionJson.getCodeWrapper().getCode());
								region.setName(regionJson.getName());
								region.setCountry((countryJson.getCodeWrapper() == null || countryJson.getCodeWrapper().getCode() == null) ? null : country);
								regionsRepository.save(region);
							}
							country.addRegion(region);
						}
						List<Settlement> citysJson = regionJson.getSettlements();
						for (Settlement cityJson : citysJson) {
							Citys city = new Citys();
							if (cityJson.getCodeWrapper() != null && cityJson.getCodeWrapper().getCode() != null && cityJson.getName().equals("Белгород")) {
								Optional<Citys> cityOptional = citysRepository.findByCode(cityJson.getCodeWrapper().getCode());
								if (cityOptional.isPresent()) {
									city = cityOptional.get();
								} else {
									city.setCode(cityJson.getCodeWrapper().getCode());
									city.setNameOfCity(cityJson.getName());
									city.setRegion((regionJson.getCodeWrapper() == null || regionJson.getCodeWrapper().getCode() == null) ? null : region);
									citysRepository.save(city);
								}
								region.addCity(city);
							}
							if (cityJson.getCodeWrapper() == null || cityJson.getCodeWrapper().getCode() == null || !cityJson.getName().equals("Белгород")) continue;
							Stations station = new Stations();
							List<Station> stationsJson = cityJson.getStations();
							for (Station stationJson : stationsJson) {
								Optional<Stations> stationOptional;
								if (stationJson.getCode() == null) continue;
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
								city.addStation(station);
							}
						}
					}
				}
			}
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		System.out.println("The stations initializateed\n");
	}
}
*/