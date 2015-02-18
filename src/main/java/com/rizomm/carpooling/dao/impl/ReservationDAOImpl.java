package com.rizomm.carpooling.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rizomm.carpooling.dao.ReservationDAO;
import com.rizomm.carpooling.model.Reservation;

@Repository("reservationDAO")
public class ReservationDAOImpl implements ReservationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Reservation create() {
		return new Reservation();
	}

	@Override
	public void save(Reservation reservation) {
		sessionFactory.getCurrentSession().save(reservation);
	}

	@Override
	public void delete(Reservation reservation) {
		sessionFactory.getCurrentSession().delete(reservation);
	}

	@Override
	public void update(Reservation reservation) {
		sessionFactory.getCurrentSession().update(reservation);
	}
}
