package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.Trajet;
import com.example.demo.Services.TrajetService;

import java.util.List;

@RestController
public class TrajetController {

    @Autowired
    private TrajetService trajetService;

    @GetMapping("/trajets")
    public List<Trajet> getAllTrajets() {
        return trajetService.getAllTrajets();
    }

    @GetMapping("/afficherTrajetById/{id}")
    public Trajet getTrajetById(@PathVariable int id) {
        return trajetService.getTrajetById(id);
    }

    @PostMapping("/ajouterTrajet")
    public Trajet createTrajet(@RequestBody Trajet trajet) {
        return trajetService.saveTrajet(trajet);
    }

    @PutMapping("/modifierTrajet/{id}")
    public Trajet updateTrajet(@PathVariable int id, @RequestBody Trajet trajetDetails) {
        return trajetService.updateTrajet(id, trajetDetails);
    }

    @DeleteMapping("/supprimerTrajet/{id}")
    public void deleteTrajet(@PathVariable int id) {
        trajetService.deleteTrajet(id);
    }
}
