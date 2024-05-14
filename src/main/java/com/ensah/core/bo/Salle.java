package com.ensah.core.bo;
import java .util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdSalle;
	private String Nom;
	private Integer capacite;
	
	@OneToMany(mappedBy = "salle", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	
    private Set<Surveillance> Surveillances;

	
	
	
	public Long getIdSalle() {
		return IdSalle;
	}

	public void setIdSalle(Long idSalle) {
		IdSalle = idSalle;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public Set<Surveillance> getSurveillances() {
		return Surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		Surveillances = surveillances;
	}
	
	
	
	

}
