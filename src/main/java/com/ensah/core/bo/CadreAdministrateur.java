package com.ensah.core.bo;
import java .util.*;


import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="idCadreAdmin")
public class CadreAdministrateur extends Personne {
  
   private String grade;
   
   @OneToMany(mappedBy = "Administrateur", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Surveillance> surveillances = new HashSet<Surveillance>();
   
   
   
  

////getters and setters
public String getGrade() {
	return grade;
}

public void setGrade(String grade) {
	this.grade = grade;
}

public Set<Surveillance> getSurveillances() {
	return surveillances;
}

public void setSurveillances(Set<Surveillance> surveillances) {
	
	if (this.surveillances != null) {
		for (Surveillance surveillance : this.surveillances) {
			surveillance.setAdministrateur(null);
		}
	}

	this.surveillances = surveillances;

	
	if (surveillances != null) {
		for (Surveillance surveillance : this.surveillances) {
			if (surveillance.getAdministrateur() != this) {
				surveillance.setAdministrateur(this);
			}
		}
	}


} 


   
}