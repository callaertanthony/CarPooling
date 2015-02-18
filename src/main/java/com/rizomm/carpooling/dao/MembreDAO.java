package com.rizomm.carpooling.dao;

import java.util.List;

import com.rizomm.carpooling.model.Membre;

public interface MembreDAO {
	public Membre create();
	public void save(Membre membre);
	public void delete(Membre membre);
	public void update(Membre membre);
	public Membre findById(int id);
	public List<Membre> findAll();
	public List<Membre> findByNomAndPrenom(String nom, String prenom);
}
