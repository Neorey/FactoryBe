package com.Factory.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.Factory.entity.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Matiere {
	
	@JsonView(JsonViews.Common.class)
	@Id
	@Column(name = "matiere_id")
	@GeneratedValue
	private long id;
	
	@JsonView(JsonViews.Common.class)
	private String titre;
	
	@JsonView(JsonViews.Common.class)
	private int duree;
	
	@JsonView(JsonViews.Common.class)
	private String objectifs;
	
	@JsonView(JsonViews.Common.class)
	private String prerequis;
	
	@JsonView(JsonViews.Common.class)
	private String contenu;
	
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.ORDINAL)
	private ENiveau niveau;
	
	
	@JsonView(JsonViews.MatiereWithFormateurs.class)
	@ManyToMany(mappedBy="listeMatiere")
	private List<Formateur> listeFormateur;
	
	
	@JsonView(JsonViews.MatiereWithModule.class)
	@OneToOne
	private Module module;

	
	

	@Version
	private int version;
	

	public Matiere() {
	}

	public Matiere(List<Formateur> listeFormateur, String titre, int duree, String objectifs, String prerequis,
			String contenu, ENiveau niveau) {
		super();
		this.listeFormateur = listeFormateur;
		this.titre = titre;
		this.duree = duree;
		this.objectifs = objectifs;
		this.prerequis = prerequis;
		this.contenu = contenu;
		this.niveau = niveau;
	}

	public List<Formateur> getListeFormateur() {
		return listeFormateur;
	}

	public void setListeFormateur(List<Formateur> listeFormateur) {
		this.listeFormateur = listeFormateur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public ENiveau getNiveau() {
		return niveau;
	}

	public void setNiveau(ENiveau niveau) {
		this.niveau = niveau;
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	

}
