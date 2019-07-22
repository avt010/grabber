package com.example.springresttest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springresttest.entity.Transports;
import com.example.springresttest.repository.TransportsRepository;

@Service
public class TransportsService {
	
	@Autowired
	private TransportsRepository transportsRepository;
	
	@Autowired
	private CategorysOfTransportService categorysOfTransportService;
	
	public Transports saveOrUpdate(String number, String category) {
		Transports transport;
		Optional<Transports> transportOptional = transportsRepository.findByNumber(number);
		if (transportOptional.isPresent()) {
			transport = transportOptional.get();
		} else {
			transport = new Transports();
			transport.setNumber(number);
			transport.setCategoryOfTransport(category == null ? null : categorysOfTransportService.saveOrUpdateByName(category));
			transportsRepository.save(transport);
		}
		return transport;
	}
}
