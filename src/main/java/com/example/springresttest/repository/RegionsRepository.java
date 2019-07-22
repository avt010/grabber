package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Regions;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, Long>{

	Optional<Regions> findByCode(String code);
	
}
