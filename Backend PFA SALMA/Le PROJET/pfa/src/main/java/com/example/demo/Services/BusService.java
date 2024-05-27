package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Bus;
import com.example.demo.Repositories.BusRepository;

import java.util.List;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }

    public Bus getBusById(int id) {
        return busRepository.findById(id).orElse(null);
    }
    public Bus getBusByMatricule(String matricule) {
		return busRepository.findByMatricule(matricule);
	}

    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Bus updateBus(int id, Bus busDetails) {
        Bus bus = busRepository.findById(id).orElse(null);
        if (bus != null) {
            bus.setMatricule(busDetails.getMatricule());
            bus.setModele(busDetails.getModele());
            bus.setPlace(busDetails.getPlace());
            bus.setConducteur(busDetails.getConducteur());
            bus.setTrajets(busDetails.getTrajets());
            return busRepository.save(bus);
        }
        return null;
    }

    public void deleteBus(int id) {
        busRepository.deleteById(id);
    }
}

