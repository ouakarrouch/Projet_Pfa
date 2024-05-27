package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.Passager;
import com.example.demo.Services.PassagerService;

import java.util.List;

@RestController
public class PassagerController {

    @Autowired
    private PassagerService passagerService;

    @GetMapping("/passagers")
    public List<Passager> getAllPassagers() {
        return passagerService.getAllPassagers();
    }

    @GetMapping("/afficherPassagerById/{id}")
    public Passager getPassagerById(@PathVariable int id) {
        return passagerService.getPassagerById(id);
    }
    
    @GetMapping("/afficherPassagerByEmail/{email}")
    public Passager getPassagerByEmail(@PathVariable String email) {
        return passagerService.getPassagerByEmail(email);
    }

    @PostMapping("/ajouterPassager")
    public Passager createPassager(@RequestBody Passager passager) {
        return passagerService.savePassager(passager);
    }

    @PutMapping("/modifierPassager/{id}")
    public Passager updatePassager(@PathVariable int id, @RequestBody Passager passagerDetails) {
        return passagerService.updatePassager(id, passagerDetails);
    }

    @DeleteMapping("/supprimerPassager/{id}")
    public void deletePassager(@PathVariable int id) {
        passagerService.deletePassager(id);
    }
}
