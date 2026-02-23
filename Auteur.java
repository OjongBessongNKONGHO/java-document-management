package com.DGE;

public class Auteur {
	
	    private int id;
	    private String nom;
	    private String mdp;

	    public Auteur(int id, String nom, String mdp) {
	        this.id = id;
	        this.nom = nom;
	        this.mdp = mdp;
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

	    public String getMdp() {
	        return mdp;
	    }

	    public void setMdp(String mdp) {
	        this.mdp = mdp;
	    }

	    // Méthode pour afficher les informations de l'auteur
	    @Override
	    public String toString() {
	        return "Auteur{" +
	                "id=" + id +
	                ", nom='" + nom + '\'' +
	                ", mdp='" + mdp + '\'' +
	                '}';
	    }

	    // Méthode pour vérifier si le mot de passe est correct
	    public boolean verifierMdp(String mdp) {
	        return this.mdp.equals(mdp);
	    }
	}

	