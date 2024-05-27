package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
public class CartePaiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double numeroCarte;
	private int cvv;
	private Date dateExpiration;

	@ManyToOne
	@JoinColumn(name = "passager_id", nullable = false)
	private Passager passager;

	@OneToMany(mappedBy = "cartePaiement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Paiement> paiements;

	public CartePaiement() {
		super();
	}

	public CartePaiement(double numeroCarte, int cvv, Date dateExpiration, Passager passager, List<Paiement> paiements) {
		super();
		this.numeroCarte = numeroCarte;
		this.cvv = cvv;
		this.dateExpiration = dateExpiration;
		this.passager = passager;
		this.paiements = paiements;
	}

	public double getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(double numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
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
		return "CartePaiement [id=" + id + ", numeroCarte=" + numeroCarte + ", cvv=" + cvv + ", dateExpiration="
				+ dateExpiration + ", passager=" + passager + ", paiements=" + paiements + "]";
	}

}
