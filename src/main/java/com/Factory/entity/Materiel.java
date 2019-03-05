package com.Factory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Materiel {

@Id
@GeneratedValue(strategy=GenerationType.TABLE)
@Column(name="materiel_id")
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
