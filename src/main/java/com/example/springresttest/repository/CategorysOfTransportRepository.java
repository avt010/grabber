package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.CategorysOfTransport;

@Repository
public interface CategorysOfTransportRepository extends JpaRepository<CategorysOfTransport, Long> {
	
	Optional<CategorysOfTransport> findByName(String name);
}