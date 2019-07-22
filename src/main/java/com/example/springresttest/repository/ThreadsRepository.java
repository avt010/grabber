package com.example.springresttest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springresttest.entity.Threads;

@Repository
public interface ThreadsRepository extends JpaRepository<Threads, Long> {

	Optional<Threads> findByUid(String uid);

}
