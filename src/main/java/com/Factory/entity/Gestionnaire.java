package com.Factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Gestionnaire extends Personne {

	public Gestionnaire() {
		super();
	}
	
	@OneToOne
	private Formation formation;



	@OneToMany(mappedBy = "gestionnaire")
	private List<Module> module;


	public List<Module> getModule() {
		return module;
	}
	
	public void setModule(List<Module> module) {
		this.module = module;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	
}
