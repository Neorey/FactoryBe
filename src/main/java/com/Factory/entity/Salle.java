package com.Factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.Factory.entity.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("salle")
public class Salle extends Materiel {

	
	@JsonView(JsonViews.Common.class)
	private int capacite;
	
	@JsonView(JsonViews.Common.class)
	private String nom;

	@JsonView(JsonViews.SalleWithModule.class)
	@OneToOne
	private Module module;

	
	
	public Salle(int capacite, String nom, Module module) {
		super();
		this.capacite = capacite;
		this.nom = nom;
		this.module = module;
	}

	public Salle() {
		super();
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
