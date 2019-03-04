package com.Factory.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Formateur extends Personne {

	@ManyToMany
	@JoinColumn(name="matiere_id")
	private Matiere matiere;
	
	public Formateur() {
		super();
	}

}
