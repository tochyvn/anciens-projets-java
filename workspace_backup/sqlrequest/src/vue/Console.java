package vue;

import java.util.Vector;

import controleur.Manager;

public class Console {

	public Console() {
		
	}

	public static void main(String[] args) {
		Manager.getInstance().getConnexion("jdbc:mysql://localhost:8889/TOCHAP", "root", "root");
		//Manager.getInstance().recupSql("SELECT * FROM ENCHERE");
		Vector<String> nomTables = Manager.getInstance().getMesTables();
		System.out.println("\n\n++++++++++++TRAITEMENT DES JOINTURES DEBOGAGE++++++++++++++++++");
 		Vector<String> jointures = Manager.getInstance().getJointures(nomTables);
 		System.out.println("\n\n-------------LES JOINTURES-----------------");
 		for (String string : jointures) {
			System.out.println(string);
		}
 		
	}

}
