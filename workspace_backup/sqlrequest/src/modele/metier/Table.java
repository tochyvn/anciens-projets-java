package modele.metier;

import java.util.HashMap;
import java.util.Vector;
/**
 * Classe representant la structure d'une table
 * @author TOCHAP
 *@version 1.0.1
 */
public class Table {
	
	private String name;
	/**
	 * Represente une collection contenant les colonnes de la table
	 */
	private Vector<Colonne> colonnes;
	/**
	 * Represente un mappage de clé etrangère de la table
	 */
	private HashMap<String, Vector<String>> foreignKeys;
	/**
	 * represente une collection contenant les colonnes composants la clé primaire de la table
	 */
	private Vector<String> primaryKeys;
	/**
	 * Constructeur de la classe 
	 * @param name represente le nom de la table
	 */
	public Table(String name) {
		colonnes = new Vector<Colonne>();
		this.name = name;
		primaryKeys = new Vector<String>();
		setForeignKeys(new HashMap<String, Vector<String>>());
	}
	/**
	 * Methode permettant de recuperer le nom de la table
	 * @return represente le nom de la table
	 */
	public String getName() {
		return name;
	}
	/**
	 * Methode permettant de recuperer les colonnes de la table
	 * @return represente le tableau de colonnes
	 */
	public Vector<Colonne> getColonnes() {
		return colonnes;
	}
	/**
	 * Methode permettant d'ajouter une colonne à la table
	 * @param col represente la colonne à ajouter
	 */
	public void addColonnes(Colonne col) {
		this.colonnes.add(col);
	}
	/**
	 * Permet de recuperer dans une collection les colonnes composants la clé primaire de la table 
	 * @return represente la collection de colonnes retournées representant la clé primaire
	 */
	public Vector<String> getPrimaryKeys() {
		return primaryKeys;
	}
	/**
	 * Methode permettant d'affecter une clé primaire à la table
	 * @param primaryKeys la collection de colonnes à affecter comme clé primaire
	 */
	public void setPrimaryKeys(Vector<String> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}
	/**
	 * Methode de recuperer les clés etrangères de la table
	 * @return represente le HashMap retourné, contenant les clés etrangères de la table
	 * 
	 */
	public HashMap<String, Vector<String>> getForeignKeys() {
		return foreignKeys;
	}
	/**
	 * Methode permettant d'affecter une valeur à l'ensemble des clés etrangères de la table
	 * @param foreignKeys Collection HashMap de clés etrangères
	 */
	public void setForeignKeys(HashMap<String, Vector<String>> foreignKeys) {
		this.foreignKeys = foreignKeys;
	}
	/*
	public String testAffichePk() {
		String str = "";
		for (String pk : primaryKeys) {
			str += " "+pk+" ";
		}
		return "("+str+")";	
	}
	
	public void testAfficheFk() {
		
		for (Map.Entry<String, Vector<String>> fk : foreignKeys.entrySet()) {
			String pkTable = fk.getKey();
			String fkCol = "";
			for (String fkColumn : fk.getValue()) {
				fkCol += "( "+fkColumn+" )";
			}
			System.out.println("Table primaire referencée : "+pkTable);
			System.out.println("Champ clés etrangères : "+fkCol);
		}
	}
	*/
}
