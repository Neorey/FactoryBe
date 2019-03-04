package com.Factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SALLE")
public class Salle extends Materiel {

private int capacité;
private String nom;


public Salle(int capacité, String nom) {
	super();
	this.capacité = capacité;
	this.nom = nom;
}


public Salle() {
	super();
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
