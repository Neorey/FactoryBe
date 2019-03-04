package com.Factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Gestionnaire extends Personne {

	public Gestionnaire() {
		super();
	}

	@OneToMany(mappedBy = "module_id")
	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

}
