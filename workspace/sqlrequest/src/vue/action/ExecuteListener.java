package vue.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controleur.Manager;
import vue.composant.MaTable;
import vue.composant.MaTableModel;
/**
 * Classe permettant d'ecouter le bouton executer sur la fenetre principale
 * @author TOCHAP 
 *@version 1.0.1
 */
public class ExecuteListener implements ActionListener {
	
	private MaTable table;
	private JTextField select;
	private JTextField from;
	private JEditorPane where1;
	private JTextField where2;
	/**
	 * Constructeur de la classe 
	 * @param table represente la table dans laquelle on doit affiché afficher le resultat d'une requete
	 * @param select represente la zone de selection des colonnes
	 * @param from represente la zone de specification des tables intervenants dans la selection
	 * @param where1 represente la zone de jointures
	 * @param where2 represente la zone de restriction personnalisé
	 */
	public ExecuteListener(MaTable table, JTextField select, JTextField from,
			JEditorPane where1, JTextField where2) {
		this.table = table;
		this.select = select;
		this.from = from;
		this.where1 = where1;
		this.where2 = where2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//SI la connexion a bien été établie
		if (Manager.conn != null) {
			String query = buildQuery();
			//On envoie la requete au manager pour l'analyse
			boolean bool = Manager.getInstance().analyseSql(query);
			//Si la requete s'est executée correctement
			if (bool == false) {
				Vector<String> titres = Manager.getInstance().getLesTitres();
				Vector<Vector<String>> contenu = Manager.getInstance().getContenu();
				MaTableModel model = new MaTableModel(contenu, titres);
				table.setModel(model);
			} else {
				JOptionPane.showMessageDialog(null,
						"Problème lors de l'execution de la requête, verifier votre requête",
						"Erreur de syntaxe SQL",
						JOptionPane.ERROR_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(null,
					"Vous n'êtes pas connecté, veillez vous connecter",
					"INFORMATION",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	/**
	 * Methode permettant de construire la requete à partir de la saisie de l'utilisateur
	 * @return represente la requete SQL saisie par l'utilisateur
	 */
	private String buildQuery() {
		String query = "";
		String champs = "SELECT "+select.getText()+" FROM ";
		String tables = from.getText();
		String condition1 = where1.getText();
		String condition2 = where2.getText();
		/*
		 * Recuperation de la requete via l'interface
		 * En tenant compte du fait que la clause where n'est pas obligatoire
		 */
		//Si les 2 zones de conditions ne sont pas vides à la fois
		if (!where1.getText().equals("") || !where2.getText().equals("")) {
			//si les 2 zones de conditions ne sont pas vides
			if (!where1.getText().equals("") && !where2.getText().equals(""))
				query = champs+tables+" WHERE "+condition1+" AND "+condition2;
			else 
				query = champs+tables+" WHERE "+condition1+condition2;
			}
		else {
			query = champs+tables;
			System.out.println(query);
		}
		return query;
	}

}
