package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entities.Utilisateur;
import com.example.demo.Repositories.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurRepository.findAll();
	}

	public Utilisateur getUtilisateurById(int id) {
		return utilisateurRepository.findById(id).orElse(null);
	}
	
	public Utilisateur getUtilisateurByEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}

	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Transactional
	public Utilisateur updateUtilisateur(int id, Utilisateur nouvelUtilisateur) {
		Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);

		if (optionalUtilisateur.isPresent()) {
			Utilisateur utilisateurExistant = optionalUtilisateur.get();

			utilisateurExistant.setNom(nouvelUtilisateur.getNom());
			utilisateurExistant.setTelephone(nouvelUtilisateur.getTelephone());
			utilisateurExistant.setEmail(nouvelUtilisateur.getEmail());
			utilisateurExistant.setPassword(nouvelUtilisateur.getPassword());

			return utilisateurRepository.save(utilisateurExistant);
		}

		return null;
	}

	public void deleteUtilisateur(int id) {
		utilisateurRepository.deleteById(id);
	}

}
