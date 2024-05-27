package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
	
}
