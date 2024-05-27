package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.Bus;
import com.example.demo.Services.BusService;

import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/bus")
    public List<Bus> getAllBus() {
        return busService.getAllBus();
    }

    @GetMapping("/afficherBusById/{id}")
    public Bus getBusById(@PathVariable int id) {
        return busService.getBusById(id);
    }
    
    @GetMapping("/afficherBusByMatricule/{matricule}")
    public Bus getBusById(@PathVariable String matricule) {
        return busService.getBusByMatricule(matricule);
    }

    @PostMapping("/ajouterBus")
    public Bus createBus(@RequestBody Bus bus) {
        return busService.saveBus(bus);
    }

    @PutMapping("/modifierBus/{id}")
    public Bus updateBus(@PathVariable int id, @RequestBody Bus busDetails) {
        return busService.updateBus(id, busDetails);
    }

    @DeleteMapping("/supprimerBus/{id}")
    public void deleteBus(@PathVariable int id) {
        busService.deleteBus(id);
    }
}
