package com.Factory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import com.Factory.entity.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Materiel {

	
@JsonView(JsonViews.Common.class)
@Id
@GeneratedValue
private Long id;

@JsonView(JsonViews.Common.class)
private String code;

@JsonView(JsonViews.Common.class)
private int cout;

@JsonView(JsonViews.Common.class)
private Boolean disponibilite;

@Version
private int version;



public Materiel() {
	super();
}


public Materiel(String code, int cout, Boolean disponibilite) {
	super();
	this.code = code;
	this.cout = cout;
	this.disponibilite = disponibilite;
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


public Boolean getDisponibilite() {
	return disponibilite;
}


public void setDisponibilite(Boolean disponibilite) {
	this.disponibilite = disponibilite;
}


public int getVersion() {
	return version;
}


public void setVersion(int version) {
	this.version = version;
}

}
