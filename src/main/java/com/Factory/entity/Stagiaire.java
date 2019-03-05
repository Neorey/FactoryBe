package com.Factory.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Stagiaire extends Personne {

	@OneToOne
	private Ordinateur ordinateur;
	
	@ManyToOne
	@JoinColumn(name="module")
	private Module module;

	public Stagiaire() {
		super();
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
