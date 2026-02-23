package com.DGE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private ListeDossiers listeDossiers;
    private static Scanner scanner = new Scanner(System.in);

    public Menu(ListeDossiers listeDossiers) {
        this.listeDossiers = listeDossiers;
    }

    public void displayMenu() {
        int choix;
        boolean stop = false;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Inscription");
            System.out.println("2. Connexion");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne

            switch (choix) {
                case 1:
                    inscription(scanner);
                    break;
                case 2:
                    Connexion();
                    
                    stop = true;
                    break;
                case 3:
                    System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                    stop = true;
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        } while (!stop);
    }

        // Menu pour gérer les dossiers
        public void afficherMenuDossiers(Scanner scanner) {
            int choix;
            do {
                System.out.println("\n==== MENU DES DOSSIERS ====");
                System.out.println("1. Afficher tous les dossiers");
                System.out.println("2. Ajouter un dossier");
                System.out.println("3. Supprimer un dossier");
                System.out.println("4. Modifier le nom d'un dossier");
                System.out.println("5. Quitter");
                System.out.print("Sélectionnez votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine(); // Consommer la ligne

                switch (choix) {
                    case 1:
                        afficherTousLesDossiers(listeDossiers, scanner);
                        break;
                    case 2:
                        ajouterDossier(listeDossiers, scanner);
                        break;
                    case 3:
                        supprimerDossier(listeDossiers, scanner);
                        break;
                    case 4:
                    	renommerDossier(listeDossiers, scanner);
                        break;
                    case 5:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } while (choix != 5);
        

    
			
		}

	private void renommerDossier(ListeDossiers listeDossiers2, Scanner scanner2) {
			// TODO Auto-generated method stub
			
		}

	private void supprimerDossier(ListeDossiers listeDossiers2, Scanner scanner2) {
			//
			
		}

	private void ajouterDossier(ListeDossiers listeDossiers, Scanner scanner) {
	    System.out.print("Entrez le nom du dossier : ");
	    String nom = scanner.nextLine();

	    System.out.print("Entrez le nom de l'auteur : ");
	    String auteur = scanner.nextLine();

	    File dossierPhysique = new File("C:\\Users\\morai\\DGE\\" + nom);
	    Dossier nouveauDossier = new Dossier(9999, nom, auteur, new ArrayList<>(), dossierPhysique);

	    listeDossiers.ajouterDossier(nouveauDossier);

	    // Vérifier si le dossier physique existe, sinon le créer
	    if (!dossierPhysique.exists()) {
	        boolean created = dossierPhysique.mkdirs();
	        System.out.println(created ? "✅ Dossier physique créé !" : "❌ Échec de la création du dossier.");
	    } else {
	        System.out.println("⚠️ Le dossier existe déjà.");
	    }

	    System.out.println("Dossier ajouté : " + nouveauDossier.getNom());
	}


	// Afficher tous les dossiers
    public static void afficherTousLesDossiers(ListeDossiers listeDossiers, Scanner scanner) {
        List<Dossier> dossiers = listeDossiers.obtenirDossiers();
        if (dossiers.isEmpty()) {
            System.out.println("Aucun dossier disponible.");
            return;
        }

        System.out.println("\n==== LISTE DES DOSSIERS ====");
        for (int i = 0; i < dossiers.size(); i++) {
            System.out.println((i + 1) + ". " + dossiers.get(i).getNom());
        }
        System.out.println("\nEntrez le numéro d'un dossier pour voir ses détails ou 0 pour revenir au menu principal : ");
        int choix = scanner.nextInt();

        if (choix > 0 && choix <= dossiers.size()) {
            afficherMenuFichiers(dossiers.get(choix - 1), scanner);
        } else if (choix != 0) {
            System.out.println("Choix invalide.");
        }
    }

    // Nouveau menu pour gérer les fichiers d'un dossier
    public static void afficherMenuFichiers(Dossier dossier, Scanner scanner) {
        int choix;
        do {
            System.out.println("\n==== MENU DES FICHIERS ====");
            System.out.println("1. Lister les fichiers");
            System.out.println("2. Ajouter un fichier");
            System.out.println("3. Supprimer un fichier");
            System.out.println("4. Télécharger un fichier");
            System.out.println("5. Envoyer un fichier");
            System.out.println("6. Retourner au menu des dossiers");
            System.out.print("Sélectionnez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la ligne après le choix

            switch (choix) {
                case 1:
                    listerFichiers(dossier);
                    break;
                case 2:
                    ajouterFichier(dossier, scanner);
                    break;
                case 3:
                    supprimerFichier(dossier, scanner);
                    break;
                case 4:
                    telechargerFichier(dossier, scanner);
                    break;
                case 5:
                    envoyerFichier(dossier, scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 6);
    }
    
// envoyer des fichiers 
    private static void envoyerFichier(Dossier dossier, Scanner scanner2) {
    	 System.out.println("\n=== ENVOYER UN FICHIER ===");
    	    System.out.print("Entrez le chemin complet du fichier à envoyer : ");
    	    String cheminFichier = scanner.nextLine();

    	    File fichierSource = new File(cheminFichier);
    	    if (fichierSource.exists() && fichierSource.isFile()) {
    	        System.out.print("Entrez un nom pour ce fichier dans le dossier : ");
    	        String nomFichier = scanner.nextLine();
    	        System.out.print("Entrez le nom de l'auteur du fichier : ");
    	        String auteurFichier = scanner.nextLine();

    	        // Ajout du fichier au dossier
    	        Fichier fichier = new Fichier(nomFichier, auteurFichier, dossier);
    	        dossier.getFichiers().add(fichier);

    	        System.out.println("Fichier '" + nomFichier + "' ajouté avec succès au dossier '" + dossier.getNom() + "' !");
    	    } else {
    	        System.out.println("Fichier introuvable ou chemin invalide.");
    	    }		
	}
// telecharger des fichier 
    
	private static void telechargerFichier(Dossier dossier, Scanner scanner2) {
		  System.out.println("\n=== TÉLÉCHARGER UN FICHIER ===");
		    System.out.print("Entrez le nom du fichier à télécharger : ");
		    String nomFichier = scanner.nextLine();

		    for (Fichier fichier : dossier.getFichiers()) {
		        if (fichier.getNom().equalsIgnoreCase(nomFichier)) {
		            System.out.println("Fichier trouvé : " + fichier.getNom());
		            System.out.print("Entrez le chemin où vous souhaitez télécharger ce fichier : ");
		            String cheminDestination = scanner.nextLine();

		            try {
		                // Simuler le téléchargement en créant une copie du fichier
		                File fichierDestination = new File(cheminDestination + "/" + fichier.getNom() + ".txt");
		                if (fichierDestination.createNewFile()) {
		                    System.out.println("Fichier téléchargé avec succès à : " + fichierDestination.getAbsolutePath());
		                } else {
		                    System.out.println("Un fichier avec le même nom existe déjà dans cet emplacement.");
		                }
		            } catch (IOException e) {
		                System.out.println("Une erreur est survenue lors du téléchargement.");
		                e.printStackTrace();
		            }
		            return;
		        }
		    }
		    System.out.println("Fichier non trouvé dans le dossier.");
		}		
	

	// Lister les fichiers dans un dossier
    public static void listerFichiers(Dossier dossier) {
        System.out.println("\n==== LISTE DES FICHIERS ====");
        if (dossier.getFichiers().isEmpty()) {
            System.out.println("Aucun fichier dans ce dossier.");
        } else {
            for (Fichier fichier : dossier.getFichiers()) {
                System.out.println("- " + fichier.getNom() + " (Auteur : " + fichier.getAuteur() + ")");
            }
        }
    }

    // Ajouter un fichier dans un dossier
    public static void ajouterFichier(Dossier dossier, Scanner scanner) {
        System.out.println("\n=== AJOUTER UN FICHIER ===");
        System.out.print("Nom du fichier : ");
        String nomFichier = scanner.nextLine();
        System.out.print("Auteur du fichier : ");
        String auteurFichier = scanner.nextLine();
        System.out.print("Contenu du fichier : ");
        String contenuFichier = scanner.nextLine();

        // Crée un objet Fichier avec les informations saisies
        Fichier fichier = new Fichier(nomFichier, auteurFichier, dossier);

        // Ajouter le fichier à la liste des fichiers du dossier
        dossier.getFichiers().add(fichier);
        

        // Crée le fichier physiquement sur le disque
        try {
            // Demander à l'utilisateur de saisir le chemin du fichier
            System.out.print("Entrez le chemin d'accès où vous souhaitez sauvegarder le fichier : ");
            String cheminFichier = scanner.nextLine();

            System.out.println(cheminFichier + "\\"+ nomFichier);
            // Créer un objet File avec le chemin entré par l'utilisateur
            File fichierDisque = new File(cheminFichier + "\\"+ nomFichier);

            // Vérifie si le fichier existe déjà
            if (fichierDisque.createNewFile()) {
                System.out.println("Fichier créé : " + fichierDisque.getName());
            } else {
                System.out.println("Le fichier existe déjà.");
            }
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la création du fichier.");
            e.printStackTrace();
        }
    }

    // Supprimer un fichier dans un dossier
    public static void supprimerFichier(Dossier dossier, Scanner scanner) {
        System.out.println("\n=== SUPPRIMER UN FICHIER ===");
        System.out.print("Entrez le nom du fichier à supprimer : ");
        String nomFichier = scanner.nextLine();

        boolean fichierTrouve = false;
        for (Fichier fichier : dossier.getFichiers()) {
            if (fichier.getNom().equalsIgnoreCase(nomFichier)) {
                dossier.getFichiers().remove(fichier);
                fichierTrouve = true;
                break;
            }
        }

        if (fichierTrouve) {
            System.out.println("Fichier supprimé avec succès !");
        } else {
            System.out.println("Fichier non trouvé.");
        }
    }
    
    //télécharger un fichier 

    // Connexion d'un utilisateur
    private void Connexion() {
        boolean isAuthenticated = false;

        do {
            System.out.println("\n=== CONNEXION ===");
            System.out.print("Email : ");
            String email = scanner.nextLine();
            System.out.print("Mot de passe : ");
            String motDePasse = scanner.nextLine();

            var tmpuser = listeDossiers.userExists(email, motDePasse);
            if (tmpuser != null) {
                System.out.println("Connexion réussie ! Bienvenue, " + tmpuser.getName());
                isAuthenticated = true;
            } else {
                System.out.println("Email ou mot de passe incorrect. Veuillez réessayer.");
            }
        } while (!isAuthenticated);

        // Si on arrive ici, c'est qu'on est connecté : on affiche le menu des dossiers
        afficherMenuDossiers(scanner);
    }


    // Inscription d'un utilisateur
    private void inscription(Scanner scanner) {
        System.out.println("=== INSCRIPTION ===");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        UtilisateurInscrit user = new UtilisateurInscrit("1", nom, email, motDePasse);
        listeDossiers.ajouterUtilisateur(user);

        System.out.println("Utilisateur ajouté avec succès !");
    }
}


