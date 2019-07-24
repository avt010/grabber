package com.example.springresttest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springresttest.entity.Carriers;
import com.example.springresttest.models.Carrier;
import com.example.springresttest.models.CarrierWrapper;
import com.example.springresttest.parsersComponents.Data;
import com.example.springresttest.repository.CarriersRepository;

@Service
public class CarriersService {
	
	@Autowired
	private CarriersRepository carriersRepository;
	
	@Autowired
	private Data data;
	
	public Carriers saveOrUpdateAndGet(Carrier carrierJson) {
		Carriers carrier;
		Optional<Carriers> carrierOptional = carriersRepository.findByCode(carrierJson.getCode());
		if (carrierOptional.isPresent()) {
			carrier = carrierOptional.get();
		} else {
			carrier = new Carriers();
			carrier.setAddress(carrierJson.getAddress());
			carrier.setCode(carrierJson.getCode());
			carrier.setContacts(carrierJson.getContacts());
			carrier.setEmail(carrierJson.getEmail());
			carrier.setLogo(carrierJson.getLogo());
			carrier.setLogoSvg(carrierJson.getLogoSvg());
			carrier.setPhone(carrierJson.getPhone());
			carrier.setTitle(carrierJson.getTitle());
			carrier.setUrl(carrierJson.getUrl());
			carriersRepository.save(carrier);
		}
		return carrier;
	}

	public void saveCarriers() {
		for (CarrierWrapper carrierWrapper : data.getCarriersWrapper()) {
			Carrier carrierJson = carrierWrapper.getCarrier();
			Carriers carrier;
			Optional<Carriers> carrierOptional = carriersRepository.findByCode(carrierJson.getCode());
			if (carrierOptional.isPresent()) {
				carrier = carrierOptional.get();
			} else {
				carrier = new Carriers();
			}
			System.out.println(carrierJson.toString());
			carrier.setAddress(carrierJson.getAddress());
			carrier.setCode(carrierJson.getCode());
			carrier.setContacts(carrierJson.getContacts());
			carrier.setEmail(carrierJson.getEmail());
			carrier.setLogo(carrierJson.getLogo());
			carrier.setLogoSvg(carrierJson.getLogoSvg());
			carrier.setPhone(carrierJson.getPhone());
			carrier.setTitle(carrierJson.getTitle());
			carrier.setUrl(carrierJson.getUrl());
			carriersRepository.save(carrier);
		}
		return;
	}
	
	
}
