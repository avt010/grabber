package com.example.springresttest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springresttest.entity.CategorysOfStation;
import com.example.springresttest.repository.CategorysOfStationRepository;

@Service
public class CategorysOfStationService {
	
	@Autowired
	private CategorysOfStationRepository categorysOfStationRepository;
	
	public CategorysOfStation saveOrUpdateByName(String name) {
		CategorysOfStation categoryOfStation;
		Optional<CategorysOfStation> categoryOfStationOptional;
		categoryOfStationOptional = categorysOfStationRepository.findByName(name);
		if (categoryOfStationOptional.isPresent()) {
			categoryOfStation = categoryOfStationOptional.get();
		} else {
			categoryOfStation = new CategorysOfStation();
			categoryOfStation.setName(name);
			categorysOfStationRepository.save(categoryOfStation);
		}
		return categoryOfStation;
	}
}
