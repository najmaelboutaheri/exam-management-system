package com.ensah.core.bo;

import java.util.Set;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private String IdExam;
     private String Nom;

	private LocalDateTime startTime;
     private int plannedDuration;
     private int actualDuration;
     
     private String academicYear;
     private String examPaper; // File path or reference to exam paper
     private String examReport;
     
     
     
     
     
	@OneToMany(mappedBy = "Exam", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
     private Set<Surveillance> Surveillances;
     
     
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "id_elementpedagogique")
     private ElementPedagogique elementPedagogique;
     
     @OneToOne(cascade = CascadeType.ALL)
 	 @JoinColumn(name = "id_elementpedagogique_examen")
     private Session session;
     
     
     @ManyToOne(fetch = FetchType.LAZY)
 	 @JoinColumn(name = "id_typeExam")
     private TypeExam typeexam;
     
     
     @ManyToOne(fetch = FetchType.LAZY)
 	 @JoinColumn(name = "id_semestre")
     private Semestre  semestre;
     
     
     
     
     
     public String getIdExam() {
 		return IdExam;
 	}


 	public void setIdExam(String idExam) {
 		IdExam = idExam;
 	}


 	public String getNom() {
 		return Nom;
 	}


 	public void setNom(String nom) {
 		Nom = nom;
 	}


 	public Set<Surveillance> getSurveillances() {
 		return Surveillances;
 	}


 	public void setSurveillances(Set<Surveillance> surveillances) {
 		Surveillances = surveillances;
 	}


 	public ElementPedagogique getElementPedagogique() {
 		return elementPedagogique;
 	}


 	public void setElementPedagogique(ElementPedagogique elementPedagogique) {
 		this.elementPedagogique = elementPedagogique;
 	}


 	public Session getSession() {
 		return session;
 	}


 	public void setSession(Session session) {
 		this.session = session;
 	}


 	public TypeExam getTypeexam() {
 		return typeexam;
 	}


 	public void setTypeexam(TypeExam typeexam) {
 		this.typeexam = typeexam;
 	}


 	public Semestre getSemestre() {
 		return semestre;
 	}


 	public void setSemestre(Semestre semestre) {
 		this.semestre = semestre;
 	}

    
    private LocalDateTime date;
    public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public int getPlannedDuration() {
		return plannedDuration;
	}


	public void setPlannedDuration(int plannedDuration) {
		this.plannedDuration = plannedDuration;
	}


	public int getActualDuration() {
		return actualDuration;
	}


	public void setActualDuration(int actualDuration) {
		this.actualDuration = actualDuration;
	}


	public String getAcademicYear() {
		return academicYear;
	}


	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}


	public String getExamPaper() {
		return examPaper;
	}


	public void setExamPaper(String examPaper) {
		this.examPaper = examPaper;
	}


	public String getExamReport() {
		return examReport;
	}


	public void setExamReport(String examReport) {
		this.examReport = examReport;
	}
     
     
     
     
     

}
