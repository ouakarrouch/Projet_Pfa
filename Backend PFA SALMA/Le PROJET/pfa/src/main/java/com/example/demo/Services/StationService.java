package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Station;
import com.example.demo.Repositories.StationRepository;

import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Station getStationById(int id) {
        return stationRepository.findById(id).orElse(null);
    }
    
    public Station getStationByNom(String nom) {
        return stationRepository.findByNom(nom);
    }


    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }

    public Station updateStation(int id, Station stationDetails) {
        Station station = stationRepository.findById(id).orElse(null);
        if (station != null) {
            station.setNom(stationDetails.getNom());
            station.setLatitude(stationDetails.getLatitude());
            station.setLongitude(stationDetails.getLongitude());
            station.setTrajetsDepart(stationDetails.getTrajetsDepart());
            station.setTrajetsArrive(stationDetails.getTrajetsArrive());
            return stationRepository.save(station);
        }
        return null;
    }

    public void deleteStation(int id) {
        stationRepository.deleteById(id);
    }
}
