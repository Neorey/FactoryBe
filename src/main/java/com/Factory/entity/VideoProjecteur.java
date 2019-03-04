package com.Factory.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



@Entity
@DiscriminatorValue("VIDEOPROJECTEUR")
public class VideoProjecteur extends Materiel {

	
private String marque;
private Date dateAchat; 

@Enumerated(EnumType.ORDINAL)
private EResolutionVideoProjecteur eResolutionVideoProjecteur ;



public VideoProjecteur(String marque, Date dateAchat, EResolutionVideoProjecteur eResolutionVideoProjecteur) {
	super();
	this.marque = marque;
	this.dateAchat = dateAchat;
	this.eResolutionVideoProjecteur = eResolutionVideoProjecteur;
}


public VideoProjecteur() {
	super();
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
