package com.Factory.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("ORDINATEUR")
public class Ordinateur extends Materiel {

private String processeur; 
private int qtRAM;
private int memoireDD;
private Date dateAchat;



public Ordinateur(String processeur, int qtRAM, int memoireDD, Date dateAchat) {
	super();
	this.processeur = processeur;
	this.qtRAM = qtRAM;
	this.memoireDD = memoireDD;
	this.dateAchat = dateAchat;
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





}
