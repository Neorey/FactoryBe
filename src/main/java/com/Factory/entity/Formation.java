package com.Factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.Factory.entity.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Formation {
	
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue
	private long id;
	
	@JsonView(JsonViews.FormationWithModules.class)
	@OneToMany(mappedBy="formation")
	private List<Module> listModules;
	
	@JsonView(JsonViews.FormationWithGestionnaire.class)
	@OneToOne(mappedBy="formation")
	private Gestionnaire gestionnaire;
	
	@Version
	private int version;
	
	

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
