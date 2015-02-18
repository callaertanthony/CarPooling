/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.rizomm.carpooling.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Reservation")
public class Reservation implements Serializable {
	public Reservation() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="COM_RIZOMM_CARPOOLING_MODEL_RESERVATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_RIZOMM_CARPOOLING_MODEL_RESERVATION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="DateReservation", nullable=true, length=255)	
	private String dateReservation;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDateReservation(String value) {
		this.dateReservation = value;
	}
	
	public String getDateReservation() {
		return dateReservation;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
