package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Station {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	private double latitude;
	private double longitude;

	@OneToMany(mappedBy = "stationDepart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Trajet> trajetsDepart;

	@OneToMany(mappedBy = "stationArrive", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Trajet> trajetsArrive;

	public Station() {
		super();
	}

	public Station(String nom, double latitude, double longitude, List<Trajet> trajetsDepart,
			List<Trajet> trajetsArrive) {
		super();
		this.nom = nom;
		this.latitude = latitude;
		this.longitude = longitude;
		this.trajetsDepart = trajetsDepart;
		this.trajetsArrive = trajetsArrive;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<Trajet> getTrajetsDepart() {
		return trajetsDepart;
	}

	public void setTrajetsDepart(List<Trajet> trajetsDepart) {
		this.trajetsDepart = trajetsDepart;
	}

	public List<Trajet> getTrajetsArrive() {
		return trajetsArrive;
	}

	public void setTrajetsArrive(List<Trajet> trajetsArrive) {
		this.trajetsArrive = trajetsArrive;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", nom=" + nom + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", trajetsDepart=" + trajetsDepart + ", trajetsArrive=" + trajetsArrive + "]";
	}

}
