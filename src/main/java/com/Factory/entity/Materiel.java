package com.Factory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public abstract class Materiel {

@Id
@GeneratedValue
private Long id;

private String code;
private int cout;
private Boolean disponibilité;

@Version
private int version;



public Materiel() {
	super();
}


public Materiel(String code, int cout, Boolean disponibilité) {
	super();
	this.code = code;
	this.cout = cout;
	this.disponibilité = disponibilité;
}



public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public int getCout() {
	return cout;
}


public void setCout(int cout) {
	this.cout = cout;
}


public Boolean getDisponibilité() {
	return disponibilité;
}


public void setDisponibilité(Boolean disponibilité) {
	this.disponibilité = disponibilité;
}


public int getVersion() {
	return version;
}


public void setVersion(int version) {
	this.version = version;
}










}
