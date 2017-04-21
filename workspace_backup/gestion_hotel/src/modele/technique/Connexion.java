package modele.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connexion {
	
	private static Connection connexion;
	private String connError;
	public static String DRIVER = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://mysql-tochyvn.alwaysdata.net:3306/tochyvn_forum";
	public static String USER = "tochyvn";
	public static String PASSWD = "TOCHlion1991";
	
	private Connexion() {
		connexion = null;
		try {
			Class.forName(DRIVER);
			connexion = DriverManager.getConnection(URL, USER, PASSWD);
		} catch (SQLException e) {
			System.out.println("Un problème est survenue lors de l'établissement de la connexion\r\n"+e.getMessage());
			connError = "Un problème est survenue lors de l'établissement de la connexion\r\n"+e.getMessage();
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
			JOptionPane.showMessageDialog(null, "Vous êtes deja connectez en tant que "+USER, "Informations",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return connexion;
	}
		

}
