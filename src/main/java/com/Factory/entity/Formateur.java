package com.Factory.entity;

import java.util.List;

import javax.persistence.*;


import com.Factory.entity.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Formateur extends Personne {

	
	@JsonView(JsonViews.FormateurWithMatieres.class)
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	joinColumns = @JoinColumn(name = "Formateur"),
	inverseJoinColumns = @JoinColumn(name = "Matiere"))
	// @JoinColumn(name="matiere_id")
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
