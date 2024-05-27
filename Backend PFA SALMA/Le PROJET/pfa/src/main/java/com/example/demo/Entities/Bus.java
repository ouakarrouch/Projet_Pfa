package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String matricule;
	private String modele;
	private int place;

	@ManyToOne
	@JoinColumn(name = "conducteur_id", nullable = false)
	private Conducteur conducteur;

	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Trajet> trajets;

	public Bus() {
		super();
	}

	public Bus(String matricule, String modele, int place, Conducteur conducteur, List<Trajet> trajets) {
		super();
		this.matricule = matricule;
		this.modele = modele;
		this.place = place;
		this.conducteur = conducteur;
		this.trajets = trajets;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", matricule=" + matricule + ", modele=" + modele + ", place=" + place
				+ ", conducteur=" + conducteur + ", trajets=" + trajets + "]";
	}

}
