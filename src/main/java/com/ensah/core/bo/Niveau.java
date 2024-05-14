package com.ensah.core.bo;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Niveau {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private String Nom;
    
    
    
    //setters and getters
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
    
	
	
}
