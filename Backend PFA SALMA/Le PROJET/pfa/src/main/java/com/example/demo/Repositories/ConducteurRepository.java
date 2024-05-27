package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Conducteur;

public interface ConducteurRepository extends JpaRepository<Conducteur, Integer> {

	Conducteur findByEmail(String email);
}
