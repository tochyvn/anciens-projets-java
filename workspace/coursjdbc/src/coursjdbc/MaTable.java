package coursjdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MaTable {
	
	private Vector<String> lesTitres;
	private Vector<Vector<String>> contenu;

	public MaTable() {
		lesTitres = new Vector<String>();
		contenu = new Vector<Vector<String>>();
	}
	
	public void recuperer(String sql) {
		String temp = "";
		//Demarrer une connexion
		Connection conn = MaConnexion.getInstance("jdbc:mysql://localhost:8889/SCOLARITE", "toch", "toch");
		ResultSet resultat = null;
		//Recuperer le resultat d'une requete
		try {
			Statement req = conn.createStatement();
			resultat = req.executeQuery(sql);
			System.out.println("requete executée avec succès");
					
			ResultSetMetaData descrip = null;
			descrip = resultat.getMetaData();
			int nbreColumn = descrip.getColumnCount();
						 
			//recuperation des entetes et ajout dans le vecteur lesTitres
			for (int i = 1; i<=nbreColumn; i++) {
				lesTitres.add(descrip.getColumnName(i));
				temp += descrip.getColumnName(i)+"\t";
			}
			temp += "\n\n";	
			//System.out.println(temp);
			//Recuperation du contenu dans un vecteur contenu
			while(resultat.next()) {
				//Vecteur contenant la ligne de resultat
				Vector<String> v = new Vector<String>();
				for (int i = 1; i<=nbreColumn; i++) {
					v.add(resultat.getString(i));
					temp += resultat.getString(i)+"\t";
				}
				//On ajoute la ligne au HashMap avec une clé numero de la ligne auto-increment
				contenu.add(v);
				temp += "\n";
			}
			//System.out.println(temp);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public Vector<String> getLesTitres() {
		return lesTitres;
	}

	public Vector<Vector<String>> getContenu() {
		return contenu;
	}

}
