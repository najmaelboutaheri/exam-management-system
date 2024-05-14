package com.ensah.core.bo;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.*;
import jakarta.persistence.Id;

public class TypeElement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String IdType;
	private String Titre;
	
	
	public String getIdType() {
		return IdType;
	}
	public void setIdType(String idType) {
		IdType = idType;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	
	

}
