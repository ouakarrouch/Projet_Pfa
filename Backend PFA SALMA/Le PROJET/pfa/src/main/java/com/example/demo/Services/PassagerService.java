package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Passager;
import com.example.demo.Repositories.PassagerRepository;

import java.util.List;

@Service
public class PassagerService {
    @Autowired
    private PassagerRepository passagerRepository;

    public List<Passager> getAllPassagers() {
        return passagerRepository.findAll();
    }

    public Passager getPassagerById(int id) {
        return passagerRepository.findById(id).orElse(null);
    }
    
    public Passager getPassagerByEmail(String email) {
		return passagerRepository.findByEmail(email);
	}

    public Passager savePassager(Passager passager) {
        return passagerRepository.save(passager);
    }

    public Passager updatePassager(int id, Passager passagerDetails) {
        Passager passager = passagerRepository.findById(id).orElse(null);
        if (passager != null) {
            passager.setTrajet(passagerDetails.getTrajet());
            passager.setCartesPaiement(passagerDetails.getCartesPaiement());
            return passagerRepository.save(passager);
        }
        return null;
    }

    public void deletePassager(int id) {
        passagerRepository.deleteById(id);
    }
}
