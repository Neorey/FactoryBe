package com.Factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Formateur extends Personne {

	@ManyToMany(mappedBy="listeFormateur")
	@JoinColumn(name="matiere_id")
	private List<Matiere> listeMatiere;
	
	public Formateur() {
		super();
	}

	public List<Matiere> getListeMatiere() {
		return listeMatiere;
	}

	public void setListeMatiere(List<Matiere> listeMatiere) {
		this.listeMatiere = listeMatiere;
	}
	
	

}
