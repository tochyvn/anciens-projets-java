package scolarite.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connexion {
	
	private static Connection connexion;
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	public final static String URL = "jdbc:mysql://localhost:8889/SCOLARITE";
	public final static String USER = "root";
	public final static String PASSWD = "root";
	
	public final static String URL1 = "jdbc:mysql://mysql-tochyvn.alwaysdata.net:3306/tochyvn_java_scolarite";
	public final static String USER1 = "tochyvn";
	public final static String PASSWD1 = "TOCHlion1991";
	
	private Connexion() {
		connexion = null;
		try {
			Class.forName(DRIVER);
			connexion = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Connexion etablie"+connexion);
		} catch (SQLException e) { 
			System.out.println("Un problème est survenue lors de l'établissement de la connexion\r\n"+e.getMessage());
			
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
	public static Connection getConnexion() {
		
		if (connexion == null) {
			new Connexion();
		} else {
			System.out.println("Déjà connecté");
			/*
			JOptionPane.showMessageDialog(null, "Vous êtes deja connectez en tant que "+USER, "Informations",
					JOptionPane.INFORMATION_MESSAGE);
					*/
		}
		return connexion;
	}
	
		
}

