package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.CartePaiement;

public interface CartePaiementRepository extends JpaRepository<CartePaiement, Integer> {
	
	CartePaiement findByNumeroCarte(double numero);
	
}
