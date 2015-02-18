package com.rizomm.carpooling.service;

import java.util.List;

import com.rizomm.carpooling.model.Membre;

public interface MembreService {
	Membre createMembre();
	void saveMembre(Membre membre);
	void updateMembre(Membre membre);
	void deleteMembre(Membre membre);
	Membre findMembreById(int id);
	List<Membre> findMembreByNomAndPrenom(String nom, String prenom);
	List<Membre> findMembreAll();
}
