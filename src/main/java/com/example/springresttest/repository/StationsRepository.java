package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Stations;

@Repository
public interface StationsRepository extends JpaRepository<Stations, Long> {

	Optional<Stations> findByCode(String code);

}
