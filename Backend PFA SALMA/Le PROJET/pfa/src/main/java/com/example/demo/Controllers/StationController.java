package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.Station;
import com.example.demo.Services.StationService;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/stations")
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/afficherStationById/{id}")
    public Station getStationById(@PathVariable int id) {
        return stationService.getStationById(id);
    }
    
    @GetMapping("/afficherStationByNom/{nom}")
    public Station getStationByNom(@PathVariable String nom) {
        return stationService.getStationByNom(nom);
    }

    @PostMapping("/ajouterStation")
    public Station createStation(@RequestBody Station station) {
        return stationService.saveStation(station);
    }

    @PutMapping("/modifierStation/{id}")
    public Station updateStation(@PathVariable int id, @RequestBody Station stationDetails) {
        return stationService.updateStation(id, stationDetails);
    }

    @DeleteMapping("/supprimerStation/{id}")
    public void deleteStation(@PathVariable int id) {
        stationService.deleteStation(id);
    }
}
