package com.rizomm.carpooling.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rizomm.carpooling.dao.ReservationDAO;
import com.rizomm.carpooling.model.Reservation;
import com.rizomm.carpooling.service.ReservationService;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDAO reservationDAO;
	
	@Override
	public Reservation createReservation() {
		return new Reservation();
	}

	@Override
	@Transactional
	public void saveReservation(Reservation reservation) {
		reservationDAO.save(reservation);
	}

	@Override
	@Transactional
	public void updateReservation(Reservation reservation) {
		reservationDAO.update(reservation);
	}

	@Override
	@Transactional
	public void deleteReservation(Reservation reservation) {
		reservationDAO.delete(reservation);
	}

}
