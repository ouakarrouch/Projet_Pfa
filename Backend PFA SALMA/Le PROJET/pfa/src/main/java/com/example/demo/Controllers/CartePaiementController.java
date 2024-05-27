package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.CartePaiement;
import com.example.demo.Services.CartePaiementService;

import java.util.List;

@RestController
public class CartePaiementController {

    @Autowired
    private CartePaiementService cartePaiementService;

    @GetMapping("/cartesPaiement")
    public List<CartePaiement> getAllCartesPaiement() {
        return cartePaiementService.getAllCartesPaiement();
    }

    @GetMapping("/afficherCartePaiementById/{id}")
    public CartePaiement getCartePaiementById(@PathVariable int id) {
        return cartePaiementService.getCartePaiementById(id);
    }
    
    @GetMapping("/afficherCartePaiementByNumeroCarte/{numero}")
    public CartePaiement getCartePaiementByNumeroCarte(@PathVariable double numero) {
        return cartePaiementService.getCartePaiementByNumeroCarte(numero);
    }

    @PostMapping("/ajouterCartePaiement")
    public CartePaiement createCartePaiement(@RequestBody CartePaiement cartePaiement) {
        return cartePaiementService.saveCartePaiement(cartePaiement);
    }

    @PutMapping("/modifierCartePaiement/{id}")
    public CartePaiement updateCartePaiement(@PathVariable int id, @RequestBody CartePaiement cartePaiementDetails) {
        return cartePaiementService.updateCartePaiement(id, cartePaiementDetails);
    }

    @DeleteMapping("/supprimerCartePaiement/{id}")
    public void deleteCartePaiement(@PathVariable int id) {
        cartePaiementService.deleteCartePaiement(id);
    }
}
