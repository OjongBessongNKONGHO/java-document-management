package com.DGE;

import java.util.ArrayList;
import java.util.List;

class ListeDossiers {
    private List<Dossier> dossiers;
    private List<UtilisateurInscrit> utilisateurs;

    public ListeDossiers() {
        this.dossiers = new ArrayList<>();
        this.utilisateurs = new ArrayList<>();
    }

    // Ajouter un dossier
    public void ajouterDossier(Dossier dossier) {
        dossiers.add(dossier);        System.out.println("Dossier ajouté: " + dossier.getNom()); // Vérification

    }

    // Ajouter un utilisateur
    public void ajouterUtilisateur(UtilisateurInscrit utilisateur) {
        utilisateurs.add(utilisateur);
    }

    // Obtenir tous les dossiers
    public List<Dossier> obtenirDossiers() {
        return dossiers;
    }

    // Obtenir tous les utilisateurs
    public List<UtilisateurInscrit> obtenirUtilisateurs() {
        return utilisateurs;
    }

    // Supprimer un utilisateur
    public boolean supprimerUtilisateur(String id) {
        for (UtilisateurInscrit utilisateur : utilisateurs) {
            if (utilisateur.getId().equals(id)) {
                utilisateurs.remove(utilisateur);
                return true;
            }
        }
        return false;
    }

    // Supprimer un dossier par son nom
    public boolean supprimerDossier(String nom) {
        for (Dossier dossier : dossiers) {
            if (dossier.getNom().equals(nom)) {
                dossiers.remove(dossier);
                return true;
            }
        }
        return false;
    }

    //  Supprimer un dossier par son ID 
    public boolean supprimerDossierParId(int id) {
        for (Dossier dossier : dossiers) {
            if (dossier.getId() == id) {
                dossiers.remove(dossier);
                return true;
            }
        }
        return false;
    }

    // Renommer un dossier par son nom
    public boolean renommerDossier(String ancienNom, String nouveauNom) {
        for (Dossier dossier : dossiers) {
            if (dossier.getNom().equals(ancienNom)) {
                dossier.setNom(nouveauNom);
                return true;
            }
        }
        
        return false;
    }

    // Upload d'un dossier : modifier son contenu
    public boolean uploadDossier(String nom, String contenu) {
        for (Dossier dossier : dossiers) {
            if (dossier.getNom().equals(nom)) {
                dossier.setContenu(contenu);
                return true;
            }
        }
        return false;
    }

    // Download d'un dossier : récupérer son contenu
    public String downloadDossier(String nom) {
        for (Dossier dossier : dossiers) {
            if (dossier.getNom().equals(nom)) {
                return dossier.getContenu();
            }
        }
        return null;
    }

    // Vérifier si un utilisateur existe
    public UtilisateurInscrit userExists(String email, String mdp) {
        // Pour débogage : affiche la liste des utilisateurs
        System.out.println(utilisateurs);

        for (var x : utilisateurs) {
            if (x.getEmail().equals(email) && x.getPwd().equals(mdp)) {
                System.out.println("x"); // Pour vérifier que la condition est atteinte
                return x;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ListeDossiers [dossiers=" + dossiers + ", utilisateurs=" + utilisateurs + "]";
 
    
    }

  

}


