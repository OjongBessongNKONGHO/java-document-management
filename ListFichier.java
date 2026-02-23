package com.DGE;

import java.util.ArrayList;
import java.util.List;

public class ListFichier {
	private List<Fichier> fichiers;

	public ListFichier() {
		this.fichiers = new ArrayList<>();
	}

	// Ajouter un fichier
	public void ajouterFichier(Fichier fichier) {
		fichiers.add(fichier);
	}

	// Modifier un fichier
	public boolean modifierFichier(String nom, String nvNom, String nvAuteur) {
		for (Fichier fichier : fichiers) {
			if (fichier.getNom().equals(nom)) {
				fichier.setNom(nvNom);
				fichier.setAuteur(nvAuteur);
				return true;
			}
		}
		return false;
	}

	// Supprimer un fichier
	public boolean supprimerFichier(String nom) {
		return fichiers.removeIf(fichier -> fichier.getNom().equals(nom));
	}

	// Déplacer un fichier dans un autre dossier
	public boolean deplacerFichier(String nomFichier, Dossier nouveauDossier) {
		for (Fichier fichier : fichiers) {
			if (fichier.getNom().equals(nomFichier)) {
				fichier.setDossier(nouveauDossier);
				return true;
			}
		}
		return false;
	}

	// Rechercher des fichiers par nom
	public List<Fichier> rechercherFichiersParNom(String nom) {
		List<Fichier> resultats = new ArrayList<>();
		for (Fichier fichier : fichiers) {
			if (fichier.getNom().equalsIgnoreCase(nom)) {
				resultats.add(fichier);
			}
		}
		return resultats;
	}

	// Rechercher des fichiers par auteur
	public List<Fichier> rechercherFichiersParAuteur(String auteur) {
		List<Fichier> resultats = new ArrayList<>();
		for (Fichier fichier : fichiers) {
			if (fichier.getAuteur().equalsIgnoreCase(auteur)) {
				resultats.add(fichier);
			}
		}
		return resultats;
	}

	// Obtenir tous les fichiers
	public List<Fichier> obtenirTousLesFichiers() {
		return fichiers;
	}

	public void modifierFichier(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub

	}

}
