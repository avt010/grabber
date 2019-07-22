package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Citys;

@Repository
public interface CitysRepository extends JpaRepository<Citys, Long> {

	Optional<Citys> findByCode(String code);

}