package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Countries;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Long>{

	Optional<Countries> findByCode(String code);

}
