package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.Conducteur;
import com.example.demo.Services.ConducteurService;

import java.util.List;

@RestController
public class ConducteurController {

    @Autowired
    private ConducteurService conducteurService;

    @GetMapping("/conducteurs")
    public List<Conducteur> getAllConducteurs() {
        return conducteurService.getAllConducteurs();
    }

    @GetMapping("/afficherConducteurById/{id}")
    public Conducteur getConducteurById(@PathVariable int id) {
        return conducteurService.getConducteurById(id);
    }
    
    @GetMapping("/afficherConducteurByEmail/{email}")
    public Conducteur getConducteurByEmail(@PathVariable String email) {
        return conducteurService.getConducteurByEmail(email);
    }


    @PostMapping("/ajouterConducteur")
    public Conducteur createConducteur(@RequestBody Conducteur conducteur) {
        return conducteurService.saveConducteur(conducteur);
    }

    @PutMapping("/modifierConducteur/{id}")
    public Conducteur updateConducteur(@PathVariable int id, @RequestBody Conducteur conducteurDetails) {
        return conducteurService.updateConducteur(id, conducteurDetails);
    }

    @DeleteMapping("/supprimerConducteur/{id}")
    public void deleteConducteur(@PathVariable int id) {
        conducteurService.deleteConducteur(id);
    }
}
