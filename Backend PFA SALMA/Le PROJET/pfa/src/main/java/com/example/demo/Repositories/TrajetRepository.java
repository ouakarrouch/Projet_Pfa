package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Integer> {
}
