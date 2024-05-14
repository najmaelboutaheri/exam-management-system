package com.ensah.core.bo;

import java.util.*;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class TypeExam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String IdTypeExam;
	private String Intitule;
	
	// La classe contient la liste des devoirs
	@OneToMany(mappedBy = "TypeExam", cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 
	private Set<Examen> type_devoir = new HashSet<Examen>();

	
	//// getters and setters
	public String getIdTypeExam() {
		return IdTypeExam;
	}

	public void setIdTypeExam(String idTypeExam) {
		IdTypeExam = idTypeExam;
	}

	public String getIntitule() {
		return Intitule;
	}

	public void setIntitule(String intitule) {
		Intitule = intitule;
	}

	public Set<Examen> getType_devoir() {
		return type_devoir;
	}

	public void setType_devoir(Set<Examen> type_devoir) {
		this.type_devoir = type_devoir;
	}


}
