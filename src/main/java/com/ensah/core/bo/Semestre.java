package com.ensah.core.bo;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
@Entity
public class Semestre {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
      private String IdSemestre;
      private String Intitule;
      
   // La classe contient la liste des devoirs
  	@OneToMany(mappedBy = "Semestre", cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 
  	private Set<Examen> Exemen = new HashSet<Examen>();

  	
  	
	public String getIdSemestre() {
		return IdSemestre;
	}

	public void setIdSemestre(String idSemestre) {
		IdSemestre = idSemestre;
	}

	public String getIntitule() {
		return Intitule;
	}

	public void setIntitule(String intitule) {
		Intitule = intitule;
	}

	public Set<Examen> getExemen() {
		return Exemen;
	}

	public void setExemen(Set<Examen> exemen) {
		Exemen = exemen;
	}
  	
}
