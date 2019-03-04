package com.Factory.entity;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Formation {

	@OneToMany(mappedBy="module_id")
	List<Module> listModules;
	
	@OneToOne(mappedBy="gestionnaire")
	Gestionnaire gestionnaire;

	public Formation() {
	}

	public List<Module> getListModules() {
		return listModules;
	}

	public void setListModules(List<Module> listModules) {
		this.listModules = listModules;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
	
	
	
}
