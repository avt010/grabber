package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.CategorysOfStation;

@Repository
public interface CategorysOfStationRepository extends JpaRepository<CategorysOfStation, Long> {

	Optional<CategorysOfStation> findByName(String name);

}