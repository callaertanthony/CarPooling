package com.rizomm.carpooling.service;

import com.rizomm.carpooling.model.Reservation;

public interface ReservationService {
	Reservation createReservation();
	void saveReservation(Reservation reservation);
	void updateReservation(Reservation reservation);
	void deleteReservation(Reservation reservation);
}
