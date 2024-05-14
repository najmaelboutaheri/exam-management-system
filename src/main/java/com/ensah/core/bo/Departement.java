package com.ensah.core.bo;
import jakarta.persistence.*;
import java.util.*;



@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
 
    
    // Liste des enseignants travaillant dans le département
    @OneToMany(mappedBy="departement",cascade=CascadeType.ALL)
    private List<Enseignant> enseignants = new ArrayList<>();
    
    

    
    
    
    
    
    
    // Constructeurs, getters et setters
    // ...

    public Departement() {
        // Constructeur par défaut
    }

    

    // Getters et setters pour les attributs
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
				if (enseignant.getDepartement() != this) {
					enseignant.setDepartement(this);
				}
			}
		}
	
    
	} 
    
    // Autres méthodes
	






}

