package com.Factory.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.Factory.entity.jsonviews.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;



@Entity
public class Module {
	
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonView(JsonViews.Common.class)
	private String nomModule;
	
	@JsonView(JsonViews.Common.class)
	@OneToOne(mappedBy = "module")
	private Matiere matiere;
	
	
	@JsonView(JsonViews.ModuleWithStagiaires.class)
	@OneToMany(mappedBy = "module")
	private List<Stagiaire> listStagiaires;

	@JsonView(JsonViews.Common.class)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDebut;
	
	@JsonView(JsonViews.Common.class)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name = "formation")
	private Formation formation;

	@ManyToOne
	@JoinColumn(name = "gestionnaire_id", nullable = true)
	private Gestionnaire gestionnaire;



	@JsonView(JsonViews.ModuleWithVideoProjecteur.class)
	@OneToOne(mappedBy="module")
	private VideoProjecteur videoProjecteur;

	@JsonView(JsonViews.ModuleWithSalle.class)
	@OneToOne(mappedBy="module")
	private Salle salle;

	
	@Version
	private int version;
	
	
	
	public Module() {
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}



	public List<Stagiaire> getListStagiaires() {
		return listStagiaires;
	}

	public void setListStagiaires(List<Stagiaire> listStagiaires) {
		this.listStagiaires = listStagiaires;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public VideoProjecteur getVideoProjecteur() {
		return videoProjecteur;
	}

	public void setVideoProjecteur(VideoProjecteur videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
