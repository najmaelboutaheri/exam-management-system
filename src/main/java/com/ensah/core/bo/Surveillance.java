package com.ensah.core.bo;
import java.util.*;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.*;
@Entity
public class Surveillance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdSurveillance;
	private String Nom;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Salle")
	private Salle salle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Exam")
	private Examen Exam;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_enseignant")
	private Enseignant enseignant_fix;
	
	@ManyToMany(mappedBy = "surveillances")
	private Set<Enseignant> enseignants = new HashSet<Enseignant>();

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_administrateur")
	private CadreAdministrateur Administrateur;


	///// Getters and setters
	public Long getIdSurveillance() {
		return IdSurveillance;
	}


	public void setIdSurveillance(Long idSurveillance) {
		IdSurveillance = idSurveillance;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public Examen getExam() {
		return Exam;
	}


	public void setExam(Examen exam) {
		Exam = exam;
	}


	public Enseignant getEnseignant_fix() {
		return enseignant_fix;
	}


	public void setEnseignant_fix(Enseignant enseignant_fix) {
		this.enseignant_fix = enseignant_fix;
	}


	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}


	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}


	public CadreAdministrateur getAdministrateur() {
		return Administrateur;
	}


	
	
	public void setAdministrateur(CadreAdministrateur administrateur) {
	      if (this.Administrateur != null && this.Administrateur != administrateur) {
					// Dissociez de l'ancien étudiant
					this.Administrateur.getSurveillances().remove(this);
				}

				this.Administrateur = administrateur;

				if (administrateur != null && !administrateur.getSurveillances().contains(this)) {
					administrateur.getSurveillances().add(this);
				}
	}
	
	
}
