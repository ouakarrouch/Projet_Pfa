package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Trajet;
import com.example.demo.Repositories.TrajetRepository;

import java.util.List;

@Service
public class TrajetService {
    @Autowired
    private TrajetRepository trajetRepository;

    public List<Trajet> getAllTrajets() {
        return trajetRepository.findAll();
    }

    public Trajet getTrajetById(int id) {
        return trajetRepository.findById(id).orElse(null);
    }

    public Trajet saveTrajet(Trajet trajet) {
        return trajetRepository.save(trajet);
    }

    public Trajet updateTrajet(int id, Trajet trajetDetails) {
        Trajet trajet = trajetRepository.findById(id).orElse(null);
        if (trajet != null) {
            trajet.setStationDepart(trajetDetails.getStationDepart());
            trajet.setStationArrive(trajetDetails.getStationArrive());
            trajet.setDateDepart(trajetDetails.getDateDepart());
            trajet.setDateArrive(trajetDetails.getDateArrive());
            trajet.setStatus(trajetDetails.getStatus());
            trajet.setBus(trajetDetails.getBus());
            trajet.setConducteur(trajetDetails.getConducteur());
            trajet.setPassagers(trajetDetails.getPassagers());
            trajet.setPaiements(trajetDetails.getPaiements());
            
            return trajetRepository.save(trajet);
        }
        return null;
    }

    public void deleteTrajet(int id) {
        trajetRepository.deleteById(id);
    }
}
