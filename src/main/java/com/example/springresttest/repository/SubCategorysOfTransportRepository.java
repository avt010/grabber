package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.SubCategorysOfTransport;

@Repository
public interface SubCategorysOfTransportRepository extends JpaRepository<SubCategorysOfTransport, Long> {

	Optional<SubCategorysOfTransport> findByNameOfSubCategoryOfTransport(String name);
	
}
