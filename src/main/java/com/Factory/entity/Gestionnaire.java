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

	@OneToMany(mappedBy = "module_id")
	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}
	
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	
}
