package com.DGE;

import java.io.File;
import java.util.List;

public class Dossier {
    private int id;
    private String nom;
    private String auteur;
    private List<Fichier> fichiers;
    private File dossierPhysique; 

    public Dossier(int id, String nom, String auteur, List<Fichier> fichiers, File dossierPhysique) {
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
        this.fichiers = fichiers;
        this.dossierPhysique = dossierPhysique; 
    }
    
    public File getDossierPhysique() {
		return dossierPhysique;
	}

	public void setDossierPhysique(File dossierPhysique) {
		this.dossierPhysique = dossierPhysique;
	}

	public Dossier() {
    	
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

	public List<Fichier> getFichiers() {
		return fichiers;
	}

	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	@Override
	public String toString() {
		return "Dossier [id=" + id + ", nom=" + nom + ", auteur=" + auteur + ", fichiers=" + fichiers + ", getId()="
				+ getId() + ", getNom()=" + getNom() + ", getAuteur()=" + getAuteur() + ", getFichiers()="
				+ getFichiers() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public void setContenu(String contenu) {
		// TODO Auto-generated method stub
		
	}

	public String getContenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dossier getUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	public void creerDossierSiInexistant() {
		// TODO Auto-generated method stub
		
	}

}

