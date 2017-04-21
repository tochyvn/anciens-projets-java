package vue.application;

import java.util.List;

import controleur.Manager;
import modele.metier.Etudiant;
import modele.metier.EtudiantException;

public class ApplicationConsole {

	public ApplicationConsole() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		/**
		 * AJOUT D'UN ETUDIANT
		 */
		Etudiant e = null;
		try {
			e = new Etudiant("ETU05", "TCHOUTA", "MIDREL AURIOL", "MASTER 2 CCI EN INFORMATIQUE");
		} catch (EtudiantException e1) {}
		finally {
			e = new Etudiant();
		}
		Manager.getInstance().addEtudiant(e);
		
		
		
		/**
		 * MODIFICATION D'UN ETUDIANT
		 *//*
		Etudiant e1 = new Etudiant();
		String reference = "ETU01";
		e1.setNom("TOCHAP NGASSAM");
		e1.setPrenom("LIONEL");
		e1.setSpecialite("CHEF DE PROJET SYSTEME D'INFORMATION");
		Manager.getInstance().updateEtudiant(reference, e1);
		*/
		
		
		/**
		 * SUPRESSION D'UN ETUDIANT
		 */
		/*
		Manager.getInstance().deleteEtudiant("ETU03");
		*/
		
		/**
		 * LISTE DES ETUDIANTS
		 */
		List<Etudiant> listeEtudiants = Manager.getInstance().getEtudiants();
		for (Etudiant etudiant : listeEtudiants) {
			System.out.println("Reference : "+etudiant.getReference()+"   "
					+ "Nom : "+etudiant.getNom()+ "   "
					+ "Prenom : "+etudiant.getPrenom()+"   "
					+ "Spécialité : "+etudiant.getSpecialite());
		}
		
	}

}
