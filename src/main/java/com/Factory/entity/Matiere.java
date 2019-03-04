package com.Factory.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Matiere {

	@ManyToMany
	@JoinTable( name="MATIERE_TITRE")
	private List<Formateur> listeFormateur;
	
	private String titre;
	private int duree;
	private String objectifs;
	private String prerequis;
	private String contenu;
	private Eniveau niveau;
	
	@Version
	private int version;
	@Id
	@Column(name="matiere_id")
	private long id;

	public Matiere() {
	}

	public Matiere(List<Formateur> listeFormateur, String titre, int duree, String objectifs, String prerequis,
			String contenu, Eniveau niveau) {
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

	public Eniveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Eniveau niveau) {
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

}
