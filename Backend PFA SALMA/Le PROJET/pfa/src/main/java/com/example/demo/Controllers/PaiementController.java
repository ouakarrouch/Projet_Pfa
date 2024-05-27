package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.Paiement;
import com.example.demo.Services.PaiementService;

import java.util.List;

@RestController
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @GetMapping("/paiements")
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/afficherPaiementById/{id}")
    public Paiement getPaiementById(@PathVariable int id) {
        return paiementService.getPaiementById(id);
    }

    @PostMapping("/ajouterPaiement")
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementService.savePaiement(paiement);
    }

    @PutMapping("/modifierPaiement/{id}")
    public Paiement updatePaiement(@PathVariable int id, @RequestBody Paiement paiementDetails) {
        return paiementService.updatePaiement(id, paiementDetails);
    }

    @DeleteMapping("/supprimerPaiement/{id}")
    public void deletePaiement(@PathVariable int id) {
        paiementService.deletePaiement(id);
    }
}
