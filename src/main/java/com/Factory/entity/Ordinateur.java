package com.Factory.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue("ORDINATEUR")
public class Ordinateur extends Materiel {

private String processeur; 
private int qtRAM;
private int memoireDD;
private Date dateAchat;


@OneToOne(mappedBy="ordinateur")
private Stagiaire stagiaire; 







public Ordinateur(String processeur, int qtRAM, int memoireDD, Date dateAchat, Stagiaire stagiaire) {
	super();
	this.processeur = processeur;
	this.qtRAM = qtRAM;
	this.memoireDD = memoireDD;
	this.dateAchat = dateAchat;
	this.stagiaire = stagiaire;
}



public Ordinateur() {
	super();
}



public String getProcesseur() {
	return processeur;
}



public void setProcesseur(String processeur) {
	this.processeur = processeur;
}



public int getQtRAM() {
	return qtRAM;
}



public void setQtRAM(int qtRAM) {
	this.qtRAM = qtRAM;
}



public int getMemoireDD() {
	return memoireDD;
}



public void setMemoireDD(int memoireDD) {
	this.memoireDD = memoireDD;
}



public Date getDateAchat() {
	return dateAchat;
}



public void setDateAchat(Date dateAchat) {
	this.dateAchat = dateAchat;
}



public Stagiaire getStagiaire() {
	return stagiaire;
}



public void setStagiaire(Stagiaire stagiaire) {
	this.stagiaire = stagiaire;
}




}