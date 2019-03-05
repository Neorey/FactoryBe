package com.Factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Formateur extends Personne {

	@ManyToMany(mappedBy="listeFormateur")
//	@JoinColumn(name="matiere_id")
	private List<Matiere> listeMatiere;
	
	@OneToOne(mappedBy = "formateur")
	private Module module;
	
	public Formateur() {
		super();
	}

	public List<Matiere> getListeMatiere() {
		return listeMatiere;
	}

	public void setListeMatiere(List<Matiere> listeMatiere) {
		this.listeMatiere = listeMatiere;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	
	

}
