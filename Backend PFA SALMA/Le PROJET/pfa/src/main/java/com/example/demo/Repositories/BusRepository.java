package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	Bus findByMatricule(String matricule);
	
}
