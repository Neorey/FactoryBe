package com.Factory.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;



@Entity
@DiscriminatorValue("VIDEOPROJECTEUR")
public class VideoProjecteur extends Materiel {

	
private String marque;
private Date dateAchat; 

@Enumerated(EnumType.ORDINAL)
private EResolutionVideoProjecteur eResolutionVideoProjecteur ;

@OneToOne
private Module module;


public VideoProjecteur() {
	super();
}





public VideoProjecteur(String marque, Date dateAchat, EResolutionVideoProjecteur eResolutionVideoProjecteur,
		Module module) {
	super();
	this.marque = marque;
	this.dateAchat = dateAchat;
	this.eResolutionVideoProjecteur = eResolutionVideoProjecteur;
	this.module = module;
}





public Module getModule() {
	return module;
}


public void setModule(Module module) {
	this.module = module;
}





public String getMarque() {
	return marque;
}


public void setMarque(String marque) {
	this.marque = marque;
}


public Date getDateAchat() {
	return dateAchat;
}


public void setDateAchat(Date dateAchat) {
	this.dateAchat = dateAchat;
}


public EResolutionVideoProjecteur geteResolutionVideoProjecteur() {
	return eResolutionVideoProjecteur;
}


public void seteResolutionVideoProjecteur(EResolutionVideoProjecteur eResolutionVideoProjecteur) {
	this.eResolutionVideoProjecteur = eResolutionVideoProjecteur;
}






}
