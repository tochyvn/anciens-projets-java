package modele.technique;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import controleur.Manager;
/**
 * Classe permettant de donner le resultat d'une requete
 * @author TOCHAP
 *@version 1.0.1
 */
public class Analyseur {
	/**
	 * represente les entetes de resultat retourné
	 */
	private Vector<String> lesTitres;
	/**
	 * Represente le contenu de resultat retourné
	 */
	private Vector<Vector<String>> contenu;
	/**
	 * Constructeur de la classe 
	 */
	public Analyseur() {
		lesTitres = new Vector<String>();
		contenu = new Vector<Vector<String>>();
	}
	
	/**
	 * Methode permettant de recuperer le resultat d'une requete et de le stocker en titres et contenu
	 * @param sql represente le requete SQL à executer
	 */
	public boolean recupSql(String sql) {
		boolean bool = false;
		try {
			System.out.println("--------------"+sql+"---------------\n");
			Statement requete = Manager.conn.createStatement();
			ResultSet resultat = requete.executeQuery(sql);
			ResultSetMetaData description = resultat.getMetaData();
			int nbreColonne = description.getColumnCount();
			
			//Recuperation des titres
			System.out.println("--------Les titres----------\n");
			lesTitres.removeAllElements();
			for(int i = 1; i<=nbreColonne; i++) {
				lesTitres.add(description.getColumnName(i));
				System.out.println(lesTitres.get(i-1)+"-----");
			}
			
			//Recuperation des lignes de resultat
			contenu.removeAllElements();
			while (resultat.next()) {
				System.out.println("------------------Ligne de resultat-------------------------\n");
				Vector<String> ligne = new Vector<String>();
				for (int i = 1; i<=nbreColonne; i++) {
					ligne.add(resultat.getString(i));
					//System.out.println(contenu.get(i-1));
				}
				contenu.add(ligne);
			}
		} catch (SQLException e) {
			bool = true;
		}
		return bool;
	}
	/**
	 * Methode permettant de recuperer les entetes retournées par le resultat de la requete
	 * @return la collection de titres retournée par la requete
	 */
	public Vector<String> getLesTitres() {
		return lesTitres;
	}
	/**
	 * Methode permettant de recuperer le contenu du resultat d'une requete ligne par ligne
	 * @return la collection contenant les lignes du resultat
	 */
	public Vector<Vector<String>> getContenu() {
		return contenu;
	}

}
