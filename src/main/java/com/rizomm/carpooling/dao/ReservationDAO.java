package com.rizomm.carpooling.dao;

import com.rizomm.carpooling.model.Reservation;

public interface ReservationDAO {
	public Reservation create();
	public void save(Reservation reservation);
	public void delete(Reservation reservation);
	public void update(Reservation reservation);
}
