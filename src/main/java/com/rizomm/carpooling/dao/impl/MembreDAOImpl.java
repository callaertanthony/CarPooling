package com.rizomm.carpooling.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rizomm.carpooling.dao.MembreDAO;
import com.rizomm.carpooling.model.Membre;

@Repository("membreDAO")
public class MembreDAOImpl implements MembreDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public MembreDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public MembreDAOImpl() {
	}

	@Override
	public Membre create() {
		return new Membre();
	}

	@Override
	public void save(Membre membre) {
		sessionFactory.getCurrentSession().save(membre);
	}

	@Override
	public void delete(Membre membre) {
		sessionFactory.getCurrentSession().delete(membre);
	}

	@Override
	public void update(Membre membre) {
		sessionFactory.getCurrentSession().update(membre);
	}

	@Override
	public Membre findById(int id) {
		return (Membre) sessionFactory.getCurrentSession().get(Membre.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Membre> findAll() {
		List<Membre> membres = sessionFactory.getCurrentSession().createQuery("from Membre").list();
		return membres;
	}

	@SuppressWarnings("unchecked")
	public List<Membre> findByNomAndPrenom(String nom, String prenom)	{
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Membre.class);
		cr.add(Restrictions.eq("nomMembre", nom));
		cr.add(Restrictions.eq("prenomMembre", prenom));
		return cr.list();
	}
}
