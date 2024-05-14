package com.ensah.core.bo;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Filiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Nom;
	


	
	// Liste des enseignants qui appartient a une filiere
    @OneToMany(mappedBy="Filiere",cascade=CascadeType.ALL)
    private List<Enseignant> enseignants = new ArrayList<>();



    //getters and setters

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public List<Enseignant> getEnseignants() {
		return enseignants;
	}




public void setEnseignants(List<Enseignant> enseignants) {
		
		if (this.enseignants != null) {
			for (Enseignant enseignant : this.enseignants) {
				enseignant.setDepartement(null);
			}
		}

		this.enseignants = enseignants;

		
		if (enseignants != null) {
			for (Enseignant enseignant  : enseignants) {
				if (enseignant.getFiliere() != this) {
					enseignant.setFiliere(this);
				}
			}
		}
	
    
	} 
    



	public String getNom() {
		return Nom;
	}




	public void setNom(String nom) {
		Nom = nom;
	}

}
