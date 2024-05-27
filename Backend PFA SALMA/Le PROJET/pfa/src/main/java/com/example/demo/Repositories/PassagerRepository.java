package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Integer> {
	
	Passager findByEmail(String email);
}
