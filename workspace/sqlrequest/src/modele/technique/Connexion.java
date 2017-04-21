package modele.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connexion {
	/*
	private  String url;
	private  String user;
	private  String passwd;
	*/
	private static Connection connexion;
	private static String classeName;
	
	private Connexion(String url, String user, String passwd) {
		//this.url = url;
		//this.user = user;
		//this.passwd = passwd;
		try {
			classeName = "com.mysql.jdbc.Driver";
			Class.forName(classeName);
			connexion = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			System.out.println("Un problème est survenue lors de l'établissement de la connexion");
		} catch (ClassNotFoundException e) {
			System.out.println("Pilote introuvable : Pas installé");
		} 
	}
	/**
	 * Methode permettant de retourne une connexion si celle-si n'existe pas
	 * @param url represente la chaîne de connexion à une base de données avec un type de pilote
	 * @param user le nom de l'utilisateur de la base
	 * @param passwd le mot de passe de l'utilisateur de la base
	 * @return
	 */
	public static Connection getConnexion(String url, String user, String passwd) {
		
		if (connexion == null) {
			new Connexion(url, user, passwd);
		} else {
			JOptionPane.showMessageDialog(null, "Vous êtes deja connectez en tant que "+user, "Informations",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return connexion;
	}
	
	public static void setClasseName(String driverClasseName) {
		Connexion.classeName = driverClasseName;
	}
	

}
