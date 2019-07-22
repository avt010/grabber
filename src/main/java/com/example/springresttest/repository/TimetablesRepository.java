package com.example.springresttest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Threads;
import com.example.springresttest.entity.Timetables;

@Repository
public interface TimetablesRepository extends JpaRepository<Timetables, Long> {

	List<Timetables> findByThread(Threads Thread);

	Optional<Timetables> findByFlyght_IdOfFlyghtAndThread_IdOfThread(Long idOfFlyght, Long idOfThread);
	
}
