package com.rizomm.carpooling.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rizomm.carpooling.dao.MembreDAO;
import com.rizomm.carpooling.model.Membre;
import com.rizomm.carpooling.service.MembreService;

@Service("membreService")
public class MembreServiceImpl implements MembreService {

	@Autowired
	MembreDAO membreDAO;
	
	@Override
	public Membre createMembre() {
		return new Membre();
	}

	@Override
	@Transactional
	public void saveMembre(Membre membre) {
		membreDAO.save(membre);
	}

	@Override
	@Transactional
	public void updateMembre(Membre membre) {
		membreDAO.update(membre);
	}

	@Override
	@Transactional
	public void deleteMembre(Membre membre) {
		membreDAO.delete(membre);
	}

	@Override
	@Transactional
	public Membre findMembreById(int id) {
		return membreDAO.findById(id);
	}

	@Override
	@Transactional
	public List<Membre> findMembreAll() {
		return membreDAO.findAll();
	}
	
	@Override
	@Transactional
	public List<Membre> findMembreByNomAndPrenom (String nom, String prenom) {
		return membreDAO.findByNomAndPrenom(nom, prenom);
	}
	
}
