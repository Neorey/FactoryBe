package com.Factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.Factory.entity.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Gestionnaire extends Personne {

	
	
	
	@JsonView(JsonViews.GestionnaireWithFormation.class)
	@OneToOne
	private Formation formation;


	@JsonView(JsonViews.GestionnaireWithModules.class)
	@OneToMany(mappedBy = "gestionnaire")
	private List<Module> module;


	
	
	public List<Module> getModule() {
		return module;
	}
	
	public Gestionnaire() {
		super();
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
