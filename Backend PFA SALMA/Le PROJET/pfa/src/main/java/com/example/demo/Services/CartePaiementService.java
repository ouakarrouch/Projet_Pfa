package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.CartePaiement;
import com.example.demo.Repositories.CartePaiementRepository;

import java.util.List;

@Service
public class CartePaiementService {
    @Autowired
    private CartePaiementRepository cartePaiementRepository;

    public List<CartePaiement> getAllCartesPaiement() {
        return cartePaiementRepository.findAll();
    }

    public CartePaiement getCartePaiementById(int id) {
        return cartePaiementRepository.findById(id).orElse(null);
    }

    public CartePaiement getCartePaiementByNumeroCarte(double numero) {
        return cartePaiementRepository.findByNumeroCarte(numero);
    }
    
    public CartePaiement saveCartePaiement(CartePaiement cartePaiement) {
        return cartePaiementRepository.save(cartePaiement);
    }

    public CartePaiement updateCartePaiement(int id, CartePaiement cartePaiementDetails) {
        CartePaiement cartePaiement = cartePaiementRepository.findById(id).orElse(null);
        if (cartePaiement != null) {
            cartePaiement.setNumeroCarte(cartePaiementDetails.getNumeroCarte());
            cartePaiement.setCvv(cartePaiementDetails.getCvv());
            cartePaiement.setDateExpiration(cartePaiementDetails.getDateExpiration());
            cartePaiement.setPassager(cartePaiementDetails.getPassager());
            cartePaiement.setPaiements(cartePaiementDetails.getPaiements());
            return cartePaiementRepository.save(cartePaiement);
        }
        return null;
    }

    public void deleteCartePaiement(int id) {
        cartePaiementRepository.deleteById(id);
    }
}
