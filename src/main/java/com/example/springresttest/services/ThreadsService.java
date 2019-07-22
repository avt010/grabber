package com.example.springresttest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springresttest.entity.Carriers;
import com.example.springresttest.entity.CategorysOfTransport;
import com.example.springresttest.entity.Flyghts;
import com.example.springresttest.entity.SubCategorysOfTransport;
import com.example.springresttest.entity.SubCatnegorysOfTransport;
import com.example.springresttest.entity.Threads;
import com.example.springresttest.entity.Transports;
import com.example.springresttest.models.Carrier;
import com.example.springresttest.models.Flyght;
import com.example.springresttest.models.ThreadOfFlyghts;
import com.example.springresttest.models.Transport;
import com.example.springresttest.repository.*;

@Service
public class ThreadsService {
	
	@Autowired
	private ThreadsRepository threadsRepository;
	
	@Autowired
	private CategorysOfTransportService categorysOfTransportService;
	
	@Autowired
	private SubCategorysOfTransportService subCategorysOfTransportService;
	
	@Autowired
	private TransportsService transportsService;
	
	@Autowired
	private CarriersRepository carriersRepository;
	
	@Autowired
	private CategorysOfTransportRepository categorysOfTransportRepository;
	
	@Autowired
	private SubCategorysOfTransportRepository subCategorysOfTransportRepository;
	
	@Autowired
	private TransportsRepository transportsRepository;
	
	public Threads saveThreadAndGet(ThreadOfFlyghts threadJson) {
		Threads thread;
		Optional<Threads> threadOptional = threadsRepository.findByUid(threadJson.getUid());
		if (threadOptional.isPresent()) {
			thread = threadOptional.get();
		} else {
			thread = new Threads();
			thread.setUid(threadJson.getUid());
			thread.setTitle(threadJson.getTitle());
			thread.setShortTitle(threadJson.getShortTitle());
			thread.setCategoryOfTransport(threadJson.getTransportType() == null ? null : categorysOfTransportService.saveOrUpdateByName(threadJson.getTransportType()));
			thread.setLinkOfMethod(threadJson.getThreadMethodLink());
			if (threadJson.getCarrier() != null && threadJson.getCarrier().getCode() != null) {
				Carrier carrierJson = threadJson.getCarrier();
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
				thread.setCarrier(carrier);
				carrier.addThread(thread);
			} else {
				thread.setCarrier(null);
			}
			if (threadJson.getTransportType() != null) {
				CategorysOfTransport categoryOfTransport;
				Optional<CategorysOfTransport> categoryOfTransportOptional;
				categoryOfTransportOptional = categorysOfTransportRepository.findByName(threadJson.getTransportType());
				if (categoryOfTransportOptional.isPresent()) {
					categoryOfTransport = categoryOfTransportOptional.get();
				} else {
					categoryOfTransport = new CategorysOfTransport();
					categoryOfTransport.setName(threadJson.getTransportType());
					categorysOfTransportRepository.save(categoryOfTransport);
				}
				thread.setCategoryOfTransport(categoryOfTransport);
				categoryOfTransport.addThread(thread);
			} else {
				thread.setCategoryOfTransport(null);
			}
			//thread.setCarrier((threadJson.getCarrier() == null || threadJson.getCarrier().getCode() == null) ? null : carriersService.saveOrUpdateAnGet(threadJson.getCarrier()));
			if (threadJson.getTransportSubtype() != null && threadJson.getTransportSubtype().getCode() != null) {
				Transport transport = threadJson.getTransportSubtype();
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
				thread.setSubCategoryOfTransport(subCategoryOfTransport);
				subCategoryOfTransport.addThread(thread);
			} else {
				thread.setSubCategoryOfTransport(null);
			}
			//thread.setSubCategoryOfTransport((threadJson.getTransportSubtype() == null || threadJson.getTransportSubtype().getCode() == null)? null : subCategorysOfTransportService.saveOrUpdate(threadJson.getTransportSubtype()));
			//thread.setTransport(threadJson.getVehicle() == null ? null : transportsService.saveOrUpdate(threadJson.getVehicle(), threadJson.getTransportType()));
			if (threadJson.getVehicle() != null) {
				Transports transport;
				Optional<Transports> transportOptional = transportsRepository.findByNumber(threadJson.getVehicle());
				if (transportOptional.isPresent()) {
					transport = transportOptional.get();
				} else {
					transport = new Transports();
					transport.setNumber(threadJson.getVehicle());
					if (threadJson.getTransportType() != null) {
						CategorysOfTransport categoryOfTransport;
						Optional<CategorysOfTransport> categoryOfTransportOptional;
						categoryOfTransportOptional = categorysOfTransportRepository.findByName(threadJson.getTransportType());
						if (categoryOfTransportOptional.isPresent()) {
							categoryOfTransport = categoryOfTransportOptional.get();
						} else {
							categoryOfTransport = new CategorysOfTransport();
							categoryOfTransport.setName(threadJson.getTransportType());
							categorysOfTransportRepository.save(categoryOfTransport);
						}
						transport.setCategoryOfTransport(categoryOfTransport);
						categoryOfTransport.addTransport(transport);
					} else {
						transport.setCategoryOfTransport(null);
					}
					//transport.setCategoryOfTransport(threadJson.getTransportType() == null ? null : categorysOfTransportService.saveOrUpdateByName(threadJson.getTransportType()));
					transportsRepository.save(transport);
				}
				thread.setTransport(transport);
				transport.addThread(thread);
			} else {
				thread.setTransport(null);
			}
			thread.setExpressType(threadJson.getExpressType());
			threadsRepository.save(thread);
		}
		return thread;
	}

	public Threads getByUid(String uid) {
		Threads thread;
		Optional<Threads> threadOptional = threadsRepository.findByUid(uid);
		//if (a);
		if (threadOptional.isPresent()) {
			thread = threadOptional.get();
		} else {
			thread = null;
		}
		return thread;
	}
	
	public Boolean isContains(String uid) {
		Optional<Threads> threadOptional = threadsRepository.findByUid(uid);
		//if (a);
		return threadOptional.isPresent() ? true : false;
	}
	
}
