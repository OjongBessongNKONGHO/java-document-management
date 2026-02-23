package com.DGE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	
    	// Initialisation des objets de démonstration
        ListeDossiers listeDossiers = new ListeDossiers();
        listeDossiers.ajouterUtilisateur(new UtilisateurInscrit("1500", "h", "h@", "123"));
        listeDossiers.ajouterUtilisateur(new UtilisateurInscrit("1000", "o", "o@", "123"));
        listeDossiers.ajouterUtilisateur(new UtilisateurInscrit("2000", "a", "a@", "123"));
        
        
        
        // Exemple de liste de Fichier pour le dossier1
        List<Fichier> fichier1Dossier = new ArrayList<>();
        fichier1Dossier.add(new Fichier("Fichier1", "hugo", null));
        fichier1Dossier.add(new Fichier("Fichier2", "hugo", null));

        // Création de Dossier N°1, lié physiquement à "C:/Users/morai/DGE/dossier1"
        Dossier dossier1 = new Dossier(
                1500,
                "dossier1",
                "Hugo",
                fichier1Dossier,
                new File("C:\\Users\\morai\\DGE\\dossier1")  // dossier physique
        );
        
        // Création de Dossier N°2, lié physiquement à "C:/Users/morai/DGE/dossier2"
        Dossier dossier2 = new Dossier(
                1000,
                "dossier2",
                "OJ",
                new ArrayList<>(),
                new File("C:\\Users\\morai\\DGE\\dossier2")  // dossier physique
        );

        // Création de Dossier N°3, lié physiquement à "C:/Users/morai/DGE/dossier3"
        Dossier dossier3 = new Dossier(
                2000,
                "dossier3",
                "Abou",
                new ArrayList<>(),
                new File("C:\\Users\\morai\\DGE\\dossier3")  // dossier physique
        );
        
        // Exemples : création des dossiers si inexistants
        dossier1.creerDossierSiInexistant();
        dossier2.creerDossierSiInexistant();
        dossier3.creerDossierSiInexistant();

      /*  System.out.println("Dossier 1: " + dossier1);
        System.out.println("Dossier 2: " + dossier2);
        System.out.println("Dossier 3: " + dossier3);*/

        listeDossiers.ajouterDossier(dossier1);
        listeDossiers.ajouterDossier(dossier2);
        listeDossiers.ajouterDossier(dossier3);

        Menu menu = new Menu(listeDossiers);
        menu.displayMenu();
    }
}
