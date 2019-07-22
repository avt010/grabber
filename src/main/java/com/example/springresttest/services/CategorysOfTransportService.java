package com.example.springresttest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springresttest.entity.CategorysOfTransport;
import com.example.springresttest.repository.CategorysOfTransportRepository;

@Service
public class CategorysOfTransportService {
	 
	@Autowired
	private CategorysOfTransportRepository categorysOfTransportRepository;
	
	public CategorysOfTransport saveOrUpdateByName(String name) {
		CategorysOfTransport categoryOfTransport;
		Optional<CategorysOfTransport> categoryOfTransportOptional;
		categoryOfTransportOptional = categorysOfTransportRepository.findByName(name);
		if (categoryOfTransportOptional.isPresent()) {
			categoryOfTransport = categoryOfTransportOptional.get();
		} else {
			categoryOfTransport = new CategorysOfTransport();
			categoryOfTransport.setName(name);
			categorysOfTransportRepository.save(categoryOfTransport);
		}
		return categoryOfTransport;
	}
	
	
}
