package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.Utilisateur;
import com.example.demo.Services.UtilisateurService;

import java.util.List;

@RestController
public class UtilisateurController {
	
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("utilisateurs")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/afficherUtilisateurById/{id}")
    public Utilisateur getUtilisateurById(@PathVariable int id) {
        return utilisateurService.getUtilisateurById(id);
    }
    
    @GetMapping("/afficherUtilisateurByEmail/{email}")
    public Utilisateur getUtilisateurByEmail(@PathVariable String email) {
        return utilisateurService.getUtilisateurByEmail(email);
    }

    @PostMapping("/ajouterUtilisateur")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @PutMapping("/modifierUtilisateur/{id}")
    public Utilisateur updateUtilisateur(@PathVariable int id, @RequestBody Utilisateur utilisateurDetails) {
        return utilisateurService.updateUtilisateur(id, utilisateurDetails);
    }

    @DeleteMapping("/supprimerUtilisateur/{id}")
    public void deleteUtilisateur(@PathVariable int id) {
        utilisateurService.deleteUtilisateur(id);
    }
}
