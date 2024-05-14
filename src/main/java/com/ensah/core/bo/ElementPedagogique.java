package com.ensah.core.bo;

import java.util.*;

import jakarta.persistence.*;

public class ElementPedagogique {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long Id;
      private String Nom;
      @ManyToOne
      @JoinColumn(name="id_Enseignant")
      private Enseignant enseignant;
      
      @OneToOne(cascade = CascadeType.ALL)
  	  @JoinColumn(name="id_typeelement_elementpedagogique")
      private TypeElement typeelement;
  
      
      
      @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  	  @JoinColumn(name = "id_ElementPedagogique")
      private Set<Niveau> niveau;
      @OneToMany(mappedBy = "elementpedagogique", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
      private List<Examen> Exemen;
      public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
      
      
     
      

}
