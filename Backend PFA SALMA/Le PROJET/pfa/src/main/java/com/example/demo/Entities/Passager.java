package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Passager extends Utilisateur {

	@ManyToOne
	@JoinColumn(name = "trajet_id", nullable = false)
	private Trajet trajet;

	@OneToMany(mappedBy = "passager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CartePaiement> cartesPaiement;

	public Passager() {
		super();
	}

	public Passager(Trajet trajet, List<CartePaiement> cartesPaiement) {
		super();
		this.trajet = trajet;
		this.cartesPaiement = cartesPaiement;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public List<CartePaiement> getCartesPaiement() {
		return cartesPaiement;
	}

	public void setCartesPaiement(List<CartePaiement> cartesPaiement) {
		this.cartesPaiement = cartesPaiement;
	}

	@Override
	public String toString() {
		return "Passager [trajet=" + trajet + ", cartesPaiement=" + cartesPaiement + "]";
	}

}
