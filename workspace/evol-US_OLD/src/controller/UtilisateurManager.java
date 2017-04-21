package controller;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import model.Connexion;
import model.beans.Utilisateur;
import model.dao.UtilisateurDAO;

public class UtilisateurManager {
	
	private static UtilisateurManager manager = null;
	private UtilisateurDAO utilisateurDAO;
	public static boolean isConnected = false;
	public static String typeCompte = "AUCUN(PAR DEFAUT)";

	private UtilisateurManager() {
		utilisateurDAO = new UtilisateurDAO(Connexion.getConnexion());
	}
	
	public static UtilisateurManager getInstance() {
		if (manager == null) {
			manager = new UtilisateurManager();
		}
		return manager;
	}
	
	public int create(Utilisateur objet) {
		int status = utilisateurDAO.create(objet);
		return status;
	}

	public int update(Utilisateur objet) {
		int status = utilisateurDAO.update(objet);
		return status;
	}

	public int delete(Integer id) {
		int status = utilisateurDAO.delete(id);
		return status;
	}
	
	public Utilisateur findById(Integer id) {
		return utilisateurDAO.findById(id);
	}

	public void findAll(ObservableList<Utilisateur> arrayList) {
		utilisateurDAO.findAll(arrayList);
	}
	
	public int getConnexion(Utilisateur user) {
		int connected = 0;
		connected = utilisateurDAO.getConnexion(user);
		/*
		if (connected == 0) {
			//Boite de dialogue password ou identifiant incorrect
			System.out.println("Boite de dialogue password ou identifiant incorrect");
		}else if (connected == 1) {
			UtilisateurManager.isConnected = true;
			typeCompte = user.getPoste().getLibelle();
			System.out.println("connected "+UtilisateurManager.isConnected+"  Droit : "+UtilisateurManager.typeCompte);
		}else {
			//Boite de dialogue problème de connexion
			System.out.println("Boite de dialogue problème de connexion");
		}
		*/
		return connected;
	}
	
	/**
	 * Deconnexion d'un utilisateur
	 */
	public void deconnected() {
		/*
		try {
			Connexion.getConnexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			System.out.println(Connexion.getConnexion().isClosed());
			Connexion.getConnexion().close();
			System.out.println(Connexion.getConnexion());
			System.out.println(Connexion.getConnexion().isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilisateurManager.isConnected = false;
		UtilisateurManager.typeCompte = "AUCUN(PAR DEFAUT)";
	}

}
