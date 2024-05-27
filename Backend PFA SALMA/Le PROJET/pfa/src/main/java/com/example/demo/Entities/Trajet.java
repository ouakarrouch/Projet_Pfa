package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trajet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "stationDepart_id", nullable = false)
	private Station stationDepart;

	@ManyToOne
	@JoinColumn(name = "stationArrive_id", nullable = false)
	private Station stationArrive;

	private Date dateDepart;
	private Date dateArrive;
	private String status;

	@ManyToOne
	@JoinColumn(name = "bus_id", nullable = false)
	private Bus bus;

	@ManyToOne
	@JoinColumn(name = "conducteur_id", nullable = false)
	private Conducteur conducteur;

	@OneToMany(mappedBy = "trajet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Passager> passagers;

	@OneToMany(mappedBy = "trajet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Paiement> paiements;

	public Trajet() {
		super();
	}

	public Trajet(Station stationDepart, Station stationArrive, Date dateDepart, Date dateArrive, String status,
			Bus bus, Conducteur conducteur, List<Passager> passagers, List<Paiement> paiements) {
		super();
		this.stationDepart = stationDepart;
		this.stationArrive = stationArrive;
		this.dateDepart = dateDepart;
		this.dateArrive = dateArrive;
		this.status = status;
		this.bus = bus;
		this.conducteur = conducteur;
		this.passagers = passagers;
		this.paiements = paiements;
	}

	public Station getStationDepart() {
		return stationDepart;
	}

	public void setStationDepart(Station stationDepart) {
		this.stationDepart = stationDepart;
	}

	public Station getStationArrive() {
		return stationArrive;
	}

	public void setStationArrive(Station stationArrive) {
		this.stationArrive = stationArrive;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	public List<Passager> getPassagers() {
		return passagers;
	}

	public void setPassagers(List<Passager> passagers) {
		this.passagers = passagers;
	}

	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Trajet [id=" + id + ", stationDepart=" + stationDepart + ", stationArrive=" + stationArrive
				+ ", dateDepart=" + dateDepart + ", dateArrive=" + dateArrive + ", status=" + status + ", bus=" + bus
				+ ", conducteur=" + conducteur + ", passagers=" + passagers + ", paiements=" + paiements + "]";
	}

}
