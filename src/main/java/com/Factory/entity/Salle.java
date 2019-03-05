package com.Factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("SALLE")
public class Salle extends Materiel {

	private int capacité;
	private String nom;

	@OneToOne(mappedBy = "salle")
	private Module module;

	public Salle(int capacité, String nom, Module module) {
		super();
		this.capacité = capacité;
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

	public int getCapacité() {
		return capacité;
	}

	public void setCapacité(int capacité) {
		this.capacité = capacité;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
