package com.DGE;

import java.util.ArrayList;
import java.util.List;

public class Fichier {
	private int id;
	 private String nom;
	    private String auteur;
	    private Dossier dossier;
	   // private String extension;
	    
	    
	    public Fichier() {
	    	
	    }
	    public 
	    Fichier(String nom, String auteur, Dossier dossier) {
	        this.nom = nom;
	        this.auteur = auteur;
	        this.dossier = dossier;

	    }

	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getAuteur() {
	        return auteur;
	    }

	    public void setAuteur(String auteur) {
	        this.auteur = auteur;
	    }

	    public Dossier getDossier() {
	        return dossier;
	    }

	    public void setDossier(Dossier dossier) {
	        this.dossier = dossier;
	    }

	    @Override
	    public String toString() {
	        return "Fichier{" +
	        		"id='" + id +'\''+
	                ",nom='" + nom + '\'' +
	                ", auteur='" + auteur + '\'' +	                
	                ", dossier=" + (dossier != null ? dossier.getNom() : "Aucun") +
	                '}';
	    }
		public String getContenu() {
			// TODO Auto-generated method stub
			return null;
		}
	}
