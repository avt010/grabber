package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Carriers;
@Repository
public interface CarriersRepository extends JpaRepository<Carriers, Long> {

	Optional<Carriers> findByCode(String code);

}