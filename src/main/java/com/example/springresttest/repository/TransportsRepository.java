package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Transports;

@Repository
public interface TransportsRepository extends JpaRepository<Transports, Long> {

	Optional<Transports> findByNumber(String number);

}