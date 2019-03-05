package com.Factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.Factory.entity.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Formateur extends Personne {

	
	@JsonView(JsonViews.FormateurWithMatieres.class)
	@ManyToMany
	@JoinTable(name = "Formateur_Matiere",
	joinColumns = @JoinColumn(name = "Formateur"),
	inverseJoinColumns = @JoinColumn(name = "Matiere"))
	// @JoinColumn(name="matiere_id")
	private List<Matiere> listeMatiere;

	
	@JsonView(JsonViews.FormateurWithModule.class)
	@JoinColumn(name = "module_id", nullable = true)
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
