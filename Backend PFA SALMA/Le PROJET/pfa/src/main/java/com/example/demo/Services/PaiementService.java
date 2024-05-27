package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Paiement;
import com.example.demo.Repositories.PaiementRepository;

import java.util.List;

@Service
public class PaiementService {
    @Autowired
    private PaiementRepository paiementRepository;

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement getPaiementById(int id) {
        return paiementRepository.findById(id).orElse(null);
    }

    public Paiement savePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement updatePaiement(int id, Paiement paiementDetails) {
        Paiement paiement = paiementRepository.findById(id).orElse(null);
        if (paiement != null) {
            paiement.setTrajet(paiementDetails.getTrajet());
            paiement.setCartePaiement(paiementDetails.getCartePaiement());
            paiement.setPrix(paiementDetails.getPrix());
            paiement.setDatePaiement(paiementDetails.getDatePaiement());
            return paiementRepository.save(paiement);
        }
        return null;
    }

    public void deletePaiement(int id) {
        paiementRepository.deleteById(id);
    }
}
