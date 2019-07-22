package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Stops;

@Repository
public interface StopsRepository extends JpaRepository<Stops, Long> {

	Optional<Stops> findByStation_IdOfStationAndThread_IdOfThreadAndStatus(Long idOfStation, Long idOfThread, Integer status);

}