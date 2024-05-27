package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "trajet_id", nullable = false)
	private Trajet trajet;

	@ManyToOne
	@JoinColumn(name = "cartePaiement_id", nullable = false)
	private CartePaiement cartePaiement;

	private float prix;
	private Date datePaiement;

	public Paiement() {
		super();
	}

	public Paiement(Trajet trajet, CartePaiement cartePaiement, float prix, Date datePaiement) {
		super();
		this.trajet = trajet;
		this.cartePaiement = cartePaiement;
		this.prix = prix;
		this.datePaiement = datePaiement;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public CartePaiement getCartePaiement() {
		return cartePaiement;
	}

	public void setCartePaiement(CartePaiement cartePaiement) {
		this.cartePaiement = cartePaiement;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", trajet=" + trajet + ", cartePaiement=" + cartePaiement + ", prix=" + prix
				+ ", datePaiement=" + datePaiement + "]";
	}

}
