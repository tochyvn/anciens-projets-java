package controleur;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import modele.metier.Colonne;
import modele.metier.SaveConnexion;
import modele.metier.Table;
import modele.technique.Analyseur;
import modele.technique.Connexion;
import modele.technique.Serialiseur;

/**
 * 
 * @author silnti
 *
 */
public class Manager {
	
	private static Manager instance;
	private Serialiseur serializeur;
	private HashMap<String, SaveConnexion> mesConnexions;
	/**
	 * Attribut permettant de stocker les tables recupereés de la base de données
	 */
	private HashMap<String, Table> mesTables2;
	/**
	 * Attribut permettant de sauvegarder la connexion
	 */
	public static Connection conn;
	/**
	 * represente l'analyseur de requete
	 */
	private Analyseur analyseur;
	
	/**
	 * Constructeur de la classe
	 */
	private Manager() {
		mesTables2 = new HashMap<String, Table>();
		analyseur = new Analyseur();
		serializeur = new Serialiseur();
		mesConnexions = new HashMap<String, SaveConnexion>();
	}
	/**
	 * Methode permettant de creer une instance de cette classe car son constructeur est en private
	 * @return represente l'unique instance de la classe 
	 */
	public static Manager getInstance() {
		if (instance == null)
			instance = new Manager();
		
		return instance;
	}
	/**
	 * Methode permettant permettant de récupérer les noms de toutes les Tables de la base de données
	 * @return represente la collection de noms de tables retournées
	 */
	public Vector<String> getMesTables() {
		Vector<String> tab = new Vector<String>();
		for (Map.Entry<String, Table> table : mesTables2.entrySet()) {
			tab.add(table.getKey());
		}
		return tab; 
	}
	/**
	 * Methode permettant de récupérer les noms de toutes les colonnes d'une table donnée
	 * @param tableName represente le nom de la table à recuperer les colonnes
	 * @return represente la collection de colonnes recuperée
	 */
	public Vector<String> getColonnes(String tableName) {
		Vector<String> cols = new Vector<String>();
		Table table = mesTables2.get(tableName);
		Vector<Colonne> colonnes = table.getColonnes();
		for (Colonne colonne : colonnes) {
			cols.add(colonne.getName());
		}
		return cols;	
	}
	
	
	//DEUXIEME METHODE PLUS OPTIMISEE
	/**
	 * Methodes permettant d'établir la connexion avec la base de données et de recuperer toutes les informations
	 * sur ses tables
	 * @param url represente la chaine à la base de données à laquelle l'on souhaite se connecter
	 * @param user represente le nom de l'utilisateur souhaitant se connecter
	 * @param passwd represente le mot de passe de l'utilisateur souhaitant se connecter
	 */
	public void getConnexion(String url, String user, String passwd) {
		conn = Connexion.getConnexion(url, user, passwd);
		/**
		 * Recuperation des tables et des colonnes de la connexion
		 */
		try {
			
			if (conn != null) {
				/*
				 * On sauve la connexion
				 */
				String connexionName = url+"?"+user+"&"+passwd;
				System.out.println(connexionName);
				if (!mesConnexions.containsKey(connexionName)) {
					SaveConnexion connex = new SaveConnexion(url, user, passwd);
					mesConnexions.put(connexionName, connex);
					//Serialisation de l'objet connexion
					serializeur.serialiser(connex);
				}
				/*
				 * Recuperation de toutes les informations sur les tables de la base de données
				 */
				DatabaseMetaData databaseMetadata = conn.getMetaData();
				/*
				 * RECUPERATION DE TOUTES LES COLONNES ET TABLES
				 */
				ResultSet colonne = databaseMetadata.getColumns(null, null, "%", "%");
				while(colonne.next()) {
					String nomColonne = colonne.getString("COLUMN_NAME");
					String nomTable = colonne.getString("TABLE_NAME");
					//Si la table n'existe pas dans la collection de table
					if (!mesTables2.containsKey(nomTable)) {
						//On cree la table temporaire à laquelle on ajoutera tout ses attributs dans la suite
						Table tempTable = new Table(nomTable);
						
						/*
						 * Recuperation des clés etrangères et primaires correspondantes
						 */
						ResultSet foreignKeys = databaseMetadata.getImportedKeys(null, null, nomTable);
						System.out.println("********Clés étrangères********");
						/*
						 * Recuperation des clés primaires et etrangère en parallèle
						 * Stockage de la relation clé primaire-clé etrangère
						 */
						HashMap<String, Vector<String>> foreign = new HashMap<String, Vector<String>>();
						Vector<String> primary = null;
						while(foreignKeys.next()) {
							
							String pkTabName = foreignKeys.getString("PKTABLE_NAME");
							String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
							String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
							/*
							 * Si la collection (foreign) de clés etrangère ne contient pas la table  
							 * ayant pour nom (pkTabName) comme table clé primaire
							 */
							if (!foreign.containsKey(pkTabName)) {
								Vector<String> fk = new Vector<String>();			
								foreign.put(pkTabName, fk);
								primary = new Vector<String>();
							} 
							/*
							 * Si la table de nom (pkTabName) n'existe pas deja dans la collection 
							 * de table (mesTables2), on va la cree et l'ajouter à celui-ci
							 */
							if (!mesTables2.containsKey(pkTabName)) {
								mesTables2.put(pkTabName, new Table(pkTabName));
							}
							foreign.get(pkTabName).add(fkColumnName);
							primary.add(pkColumnName);
							mesTables2.get(pkTabName).setPrimaryKeys(primary);
							//System.out.println("***************"+fkColumnName);
						}
						mesTables2.put(nomTable, tempTable);
						mesTables2.get(nomTable).setForeignKeys(foreign);
					} 
					//On ajoute la colonne
					mesTables2.get(nomTable).addColonnes(new Colonne(nomColonne));	
				}
				
			} 
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Problème de connexion");
		}
		
	}
	/**
	 * Methodes permettant de recuperer les jointures existantes entre plusieurs tables
	 * @param lesTables Represente la collection de tables a analyser pour trouver les jointures
	 * @return Represente le tableau de jointures retourné
	 */
	public Vector<String> getJointures(Vector<String> lesTables) {
		Vector<String> jointures = new Vector<String>();
		/**
		 * Pour chaque element de la collection ci-dessus on parcours tout les elements qui le suivent
		 */
		for(int i = 0; i<lesTables.size()-1; i++) {
			for(int j = i+1; j<lesTables.size(); j++) {
				//on recupere les tables et leurs noms 
				String nom1 = lesTables.get(i);
				String nom2 = lesTables.get(j);
				Table t1 = mesTables2.get(nom1);
				Table t2 = mesTables2.get(nom2);
				//on recupere les clés primaire
				Vector<String> pk1 = t1.getPrimaryKeys();
				Vector<String> pk2 = t2.getPrimaryKeys();
				/*
				 * On verifie si la table t1 reference la table t2 
				 */
				if (existJoin(t1, t2)[0] == 0 && existJoin(t1, t2)[1] == 1) {
					HashMap<String, Vector<String>> fk2 = t2.getForeignKeys();
					Vector<String> fk2Column = fk2.get(nom1);
					for (int k = 0; k<fk2Column.size(); k++) {
						System.out.println(nom2+"."+fk2Column.get(k)+"="+nom1+"."+pk1.get(k));
						jointures.add(nom2+"."+fk2Column.get(k)+" = "+nom1+"."+pk1.get(k));
					}
				}
				/*
				 * On verifie si la table t2 reference la table t1
				 */
				if (existJoin(t1, t2)[0] == 1 && existJoin(t1, t2)[1] == 0) {
					//System.out.println("yesssssss");
					HashMap<String, Vector<String>> fk1 = t1.getForeignKeys();
					Vector<String> fk1Column = fk1.get(nom2);
					//System.out.println(fk1Column.size());
					//if (fk1Column.size() != 0)
					for (int k = 0; k<fk1Column.size(); k++) {
						System.out.println(nom1+"."+fk1Column.get(k)+"="+nom2+"."+pk2.get(k));
						jointures.add(nom1+"."+fk1Column.get(k)+" = "+nom2+"."+pk2.get(k));
					}
				}
				
			}
		}
		return jointures;
	}
	/**
	 * Methode testant s'il existe des jointures entre 2 tables dans les 2 sens c'est a dire si
	 * la table t1 reference la table t2 et vis-versa
	 * @param t1 Represente la première table
	 * @param t2 Represente la deuxième table
	 * @return Represente le tableau d'entiers entre 0 et 1 retourné
	 * si [0,1] alors la deuxieme table t2 reference la première t1
	 * si [1,0] alors la première table t1 reference la deuxième t2
	 * si [0,0] alors il n'existe pas de jointures entre les 2 tables
	 */
	private int[] existJoin(Table t1, Table t2) {
		int[] bool = new int[]{0,0};
		for (Entry<String, Vector<String>> fk : t1.getForeignKeys().entrySet()) {
			if(fk.getKey().equals(t2.getName())) {
				bool[0] = 1;
			}
		}
		for (Entry<String, Vector<String>> fk : t2.getForeignKeys().entrySet()) {
			if(fk.getKey().equals(t1.getName())) {
				bool[1] = 1;
			}
		}
		
		return bool;
	}
	/**
	 * Methode permettant de voir si une chaine est contenue dans une collection 
	 * @param v  represente la collection de string
	 * @param s  represente la chaine à rechercher
	 * @return  renvoie O si la chaine non trouvé
	 */
	public static int exist(Vector<String> v, String s) {
		int flag = 0;
		for (String string : v) {
			if (string.equals(s)) {
				flag += 1;
			}		
		}
		return flag; 
	}
	/**
	 * Methode permettant construire la chaine de connexion et de spécifier la classe a charger 
	 * selon le pilote utilisé
	 * @param string Represente le pilote utilisé
	 * @return retourne la chaine de connexion sans le nom de la base de données
	 */
	public static String getDriver(String string) {
		String s = null;
		String classeName = null;
		
		switch (string) {
		
		case "MYSQL_DRIVER":
			s = "jdbc:mysql://localhost:8889/";
			classeName = "com.mysql.jdbc.Driver";
			break;
		
		case "SUN_DRIVER":
			s = "jdbc:odbc://localhost:8889/";
			classeName = "sun.jdbc.odbc.JdbcOdbcDriver";
		default:
			s = "jdbc:mysql://localhost:8889/";
			classeName = "com.mysql.jdbc.Driver";
			break;
		}
		//On donne le nom de la classe à charger selon le pilote utilisé
		Connexion.setClasseName(classeName);
			
		return s;
	}
	/**
	 * Methode Deleguant le traitement d'une requete à l'analyseur de requete
	 * @return retourne le status de l'execution de la requete
	 * true si la requete s'est bien executée
	 * false sinon
	 */
	public boolean analyseSql(String sql) {
		boolean status = this.analyseur.recupSql(sql);
		
		return status;
	}
	/**
	 * Methode Deleguant la recuperation des entetes du resultat d'une requete à l'analyseur de requete
	 * @return retourne une collection de chaines de caracteres
	 */
	public Vector<String> getLesTitres() {
		return this.analyseur.getLesTitres();
	}
	/**
	 * Methode Deleguant la recuperation le contenu(les cellules) 
	 * du resultat d'une requete à l'analyseur de requete
	 * @return Retourne une collections de lignes de resultat (collections de chaines de caracteres)
	 */
	public Vector<Vector<String>> getContenu() {
		return this.analyseur.getContenu();
	}

}


/*
 
for (Map.Entry<String, Table> table : mesTables2.entrySet()) {
	//affichage des noms des tables
	System.out.println(table.getKey());
	//Affichage des colonnes
	Table t = table.getValue();
	for (Colonne col : t.getColonnes()) {
		System.out.println("\t"+col.getName());
	}
	//Affichage de colonnes clés primaires
	System.out.print("Clé primaire : ");
	System.out.println(t.testAffichePk());
	//Affichage des clés etrangères
	System.out.println("____Clés etrangères___");
	t.testAfficheFk();
}



//PREMIERE METHODE MOINS EFFICACE
/*
public void getConnexion(String url, String user, String passwd) {
	conn = Connexion.getConnexion(url, user, passwd);
	//Recuperation des tables et des colonnes de la connexion
	try {
		DatabaseMetaData databaseMetadata = conn.getMetaData();
		
		ResultSet table = databaseMetadata.getTables(null, null, "%" ,new String[] {"TABLE"});
		while(table.next()) {
			String nom = table.getString("TABLE_NAME");
			System.out.println(nom);
			
			//Recuperation des colonnes par table
			ResultSet colonne = databaseMetadata.getColumns(null, null, nom, "%");
			Vector<Colonne> colonnes = new Vector<Colonne>();
			while(colonne.next()) {
				String nomCol = colonne.getString("COLUMN_NAME");
				System.out.println("\t"+nomCol);
				colonnes.add(new Colonne(nomCol));
			}
			//colonne.close();
			
			//RECUPERATION DES CLÉS PRIMAIRES
			ResultSet primaryK = databaseMetadata.getPrimaryKeys(null, null, nom);
			System.out.println("--------Colonnes clés primaires--------------\n");
			while(primaryK.next()) {
				System.out.println(primaryK.getString("COLUMN_NAME"));
			}
			
			//RECUPERATION DES CLES ETRANGÈRES
			ResultSet foreignK = databaseMetadata.getImportedKeys(null, null, nom); 
			System.out.println("--------Colonnes clés etrangère--------------\n");
			while(foreignK.next()) {
				System.out.println(foreignK.getString("FKCOLUMN_NAME"));
			}
			
			Table tab = new Table(nom);
			//Remplissage du tableau de colonnes
			tab.setColonnes(colonnes);
			mesTables.add(tab);
			for (Colonne col : colonnes) {
				System.out.println("==============="+col.getName()+"==============");
			}
		}
		System.out.println("Ajout reussie");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("\n\n--------------------------EXECUTION D4UNE REQUETE--------------------------------\n");
}
*/


/*
try {
	System.out.println("--------------"+sql+"---------------\n");
	Statement requete = conn.createStatement();
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
		Vector<String> vect = new Vector<String>(); 
		for (int i = 1; i<=nbreColonne; i++) {
			vect.add(resultat.getString(i));
			System.out.println(vect.get(i-1));
		}
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
*/
