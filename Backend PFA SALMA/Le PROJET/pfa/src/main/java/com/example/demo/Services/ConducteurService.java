package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Conducteur;
import com.example.demo.Repositories.ConducteurRepository;

import java.util.List;

@Service
public class ConducteurService {
    @Autowired
    private ConducteurRepository conducteurRepository;

    public List<Conducteur> getAllConducteurs() {
        return conducteurRepository.findAll();
    }

    public Conducteur getConducteurById(int id) {
        return conducteurRepository.findById(id).orElse(null);
    }
    
    public Conducteur getConducteurByEmail(String email) {
        return conducteurRepository.findByEmail(email);
    }

    public Conducteur saveConducteur(Conducteur conducteur) {
        return conducteurRepository.save(conducteur);
    }

    public Conducteur updateConducteur(int id, Conducteur conducteurDetails) {
        Conducteur conducteur = conducteurRepository.findById(id).orElse(null);
        if (conducteur != null) {
            conducteur.setEvaluation(conducteurDetails.getEvaluation());
            conducteur.setBuses(conducteurDetails.getBuses());
            conducteur.setTrajets(conducteurDetails.getTrajets());
            return conducteurRepository.save(conducteur);
        }
        return null;
    }

    public void deleteConducteur(int id) {
        conducteurRepository.deleteById(id);
    }
}
