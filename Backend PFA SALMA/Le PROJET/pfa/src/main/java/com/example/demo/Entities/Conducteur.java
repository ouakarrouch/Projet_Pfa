package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conducteur extends Utilisateur {

	private String evaluation;

	@OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Bus> buses;

	@OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Trajet> trajets;

	public Conducteur() {
		super();
	}

	public Conducteur(String evaluation, List<Bus> buses, List<Trajet> trajets) {
		super();
		this.evaluation = evaluation;
		this.buses = buses;
		this.trajets = trajets;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	@Override
	public String toString() {
		return "Conducteur [evaluation=" + evaluation + ", buses=" + buses + ", trajets=" + trajets + "]";
	}

}
