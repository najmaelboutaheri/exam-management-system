package com.ensah.core.bo;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String IdSession;
	private String Intitule;
	
	
	
	@OneToOne(mappedBy = "Session")
	private Examen Exemen;

	
	
	public String getIdSession() {
		return IdSession;
	}

	public void setIdSession(String idSession) {
		IdSession = idSession;
	}

	public String getIntitule() {
		return Intitule;
	}

	public void setIntitule(String intitule) {
		Intitule = intitule;
	}

	public Examen getExemen() {
		return Exemen;
	}

	public void setExemen(Examen exemen) {
		Exemen = exemen;
	}

	
	
	
}
