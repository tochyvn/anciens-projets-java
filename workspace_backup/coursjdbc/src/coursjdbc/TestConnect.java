package coursjdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;



public class TestConnect {

	public TestConnect() {
		
	}
	
	public static void listeDrivers() {
		
		for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements();){
			System.out.println(e.nextElement());
		}
		
		//hasMoreElements() renvoie un boolean: true s'il ya encore des élements dans L'enumeration
		//nextElement() recupere l'element courant et passe à l'élement suivant
	}
	
	public static void main(String[] args) {
		
		//Affichage de la liste des drivers
		listeDrivers();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("load error: mysql");
		}
		
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("load error: sun");
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("load error: oracle");
		}
		
		//mes paramètres
		String url1 = "jdbc:mysql://localhost:8889/SCOLARITE";
		String user = "toch";
		String passwd = "toch";
		
		try {
			//On cree la connexion
			Connection maConn = DriverManager.getConnection(url1, user, passwd);
			//Connection maConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/SCOLARITE?user=toch&password=toch");
			System.out.println("Connexion etablie");
			
			//Creation d'une requete
			Statement requete = maConn.createStatement();
			String sql = "SELECT * FROM PROF";
			
			//Execution de la requete
			ResultSet resultat = requete.executeQuery(sql);
			System.out.println(afficheResultset(resultat));
			
		} catch (SQLException e) {
			System.out.println("problème de connection");
		}
		
	}
	
	private static String afficheResultset(ResultSet r) {
		
		String temp = "";
		ResultSetMetaData desc;
		
		try {
			
			desc = r.getMetaData();
			int nbreCol = desc.getColumnCount();
			
			//Affichage Recuperation des entetes
			for (int i = 1; i<=nbreCol; i++) {
				temp += desc.getColumnName(i)+"\t";
				
			}
			temp += "\n\n";
			
			//Affichage des données
			
				while (r.next()) {
					for (int i = 1; i<=nbreCol; i++) {
						temp += r.getString(i)+"\t";
					}
					temp += "\n";
				}
	
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
				
		return 	temp;
		
	}
	

}
