package controleur;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import modele.technique.Connexion;


public class Manager {
	
	private static Manager instance;
	public static Connection connexion;

	private Manager() {
		super();
		instance = null;
		connexion = null;
	}
	
	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	public Connection getConnexion() {

/*******************************TEST CONNEXION DISTANTE**********************************************/
/*******************************TEST CONNEXION DISTANTE**********************************************/
/*******************************TEST CONNEXION DISTANTE**********************************************/
		connexion = Connexion.getConnexion();
		
		if (connexion != null) {
			try {
				
				System.out.println(connexion.getCatalog());
				DatabaseMetaData databaseMetadata = connexion.getMetaData();
				ResultSet table = databaseMetadata.getTables(null, null, "%" ,new String[] {"TABLE"});
				while(table.next()) {
					String nom = table.getString("TABLE_NAME");
					System.out.println(nom+"\r\n");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return connexion;
	}
	
/*******************************TEST CONNEXION DISTANTE**********************************************/
/*******************************TEST CONNEXION DISTANTE**********************************************/
/*******************************TEST CONNEXION DISTANTE**********************************************/
}
