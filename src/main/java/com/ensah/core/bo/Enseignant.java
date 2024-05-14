package com.ensah.core.bo;
import java.util.*;

import com.bo.Adresse;
import com.bo.Etudiant;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "idEnseignant")
public class Enseignant extends Personne {
	private String specialite;
	
    @ManyToOne
    @JoinColumn(name="Id_Departement")
    private Departement departement;
    
    @ManyToOne
    @JoinColumn(name="Id_Filiere")
    private Filiere filiere;
    
    @OneToMany(mappedBy="enseignant",cascade=CascadeType.ALL)
    private Set<ElementPedagogique> ElementPedagogiques;
    
    @OneToMany(mappedBy = "enseignant_fix", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Surveillance> Surveillances = new HashSet<Surveillance>();
    
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "surveillance_enseignant", joinColumns = @JoinColumn(name = "id_enseignant"
			+ ""), inverseJoinColumns = @JoinColumn(name = "id_surveillance"))
	private Set<Surveillance> surveillances = new HashSet<Surveillance>();
    
    
    
    /////Setters and getters
	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Departement getDepartement() {
		return departement;
	}

	
	
	// Setter pour Deparatement  qui gère la bidirectionnalité
		public void setDepartement(Departement departement) {
			if (this.departement != null && this.departement != departement) {
				// Dissociez de l'ancien étudiant
				this.departement.getEnseignants().remove(this);
			}

			this.departement = departement;

			if (departement != null && !departement.getEnseignants().contains(this)) {
				departement.getEnseignants().add(this);
			}
		}

	
	
	
	public Filiere getFiliere() {
		return filiere;
	}


	// Setter pour Filiere  qui gère la bidirectionnalité
     public void setFiliere(Filiere filiere) {
	      if (this.filiere != null && this.filiere != filiere) {
					// Dissociez de l'ancien étudiant
					this.filiere.getEnseignants().remove(this);
				}

				this.filiere = filiere;

				if (filiere != null && !filiere.getEnseignants().contains(this)) {
					filiere.getEnseignants().add(this);
				}
	}

	public Set<ElementPedagogique> getElementPedagogiques() {
		return ElementPedagogiques;
	}

	public void setElementPedagogiques(Set<ElementPedagogique> elementPedagogiques) {
		ElementPedagogiques = elementPedagogiques;
	}

	

	public Set<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}


}