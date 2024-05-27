package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {
	
	Station findByNom(String nom);
	
}
