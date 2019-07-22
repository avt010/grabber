package com.example.springresttest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springresttest.entity.SubCategorysOfTransport;
import com.example.springresttest.models.Transport;
import com.example.springresttest.repository.SubCategorysOfTransportRepository;

@Service
public class SubCategorysOfTransportService {
	
	@Autowired
	private SubCategorysOfTransportRepository subCategorysOfTransportRepository;
	
	public SubCategorysOfTransport saveOrUpdate(Transport transport) {
		SubCategorysOfTransport subCategoryOfTransport;
		Optional<SubCategorysOfTransport> subCategoryOfTransportOptional = subCategorysOfTransportRepository.findByNameOfSubCategoryOfTransport(transport.getTitle());
		if (subCategoryOfTransportOptional.isPresent()) {
			subCategoryOfTransport = subCategoryOfTransportOptional.get();
		} else {
			subCategoryOfTransport = new SubCategorysOfTransport();
			subCategoryOfTransport.setNameOfSubCategoryOfTransport(transport.getTitle());
			subCategoryOfTransport.setCode(transport.getCode());
			subCategorysOfTransportRepository.save(subCategoryOfTransport);
		}
		return subCategoryOfTransport;
	}
}
