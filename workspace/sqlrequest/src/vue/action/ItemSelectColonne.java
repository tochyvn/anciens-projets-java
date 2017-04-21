package vue.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import controleur.Manager;
import vue.composant.MonCombobox;
import vue.composant.MonInput;

/**
 * Classe permettant l'affichage des colonnes et les tables selectionnées en parallèle
 * @author TOCHAP
 *@version 1.0.1
 */
public class ItemSelectColonne implements ActionListener {
	
	private MonCombobox table;
	private MonCombobox colonne;
	private MonInput select;
	private MonInput from;
	private JEditorPane joint;
	private JCheckBox activateJoint;
	/**
	 * Represente les tables contenues dans la liste des tables 
	 */
	public static Vector<String> vTables = new Vector<String>();; 
	/**
	 * Represente la liste des colonnes selectionné
	 */
	public static Vector<String> vColonnes;

	/**
	 * Constructeur de la classe
	 * @param table represente la table selectionnée
	 * @param colonne represente la colonne selectionnée
	 * @param select represente la zone de selection des colonnes
	 * @param from represente la zone contenant la liste des tables concernées par la selection
	 * @param joint represente la zone de jointure automatique 
	 * @param activateJoint represente la zone d'activation de la generation automatique des jointures
	 */
	public ItemSelectColonne(MonCombobox table, MonCombobox colonne, MonInput select,
			MonInput from, JEditorPane joint, JCheckBox activateJoint) {
		this.table = table;
		this.colonne = colonne;
		this.select = select;
		this.from = from;
		this.joint = joint;
		this.activateJoint = activateJoint;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Si la connection est etablie
		if (Manager.conn != null) {
			int index = colonne.getSelectedIndex();
			//Si une colonne a eté selectionnée
			if (!(index <= 0)) {
				
				this.remplissage();
				/*
				 * Si la generation automatique de jointure est activé et si on a fait une selection sur au
				 * moins deux tables
				 */
				buildJoint();
			}
		}
		
	}
	/**
	 * Methode permettant d'acceder au tables concernées par la selection
	 * @return une collection static de table
	 */
	public static Vector<String> getV() {
		return vTables;
	}
	/**
	 * Methode permettant l'ajout automatique de noms de tables et de nom de colonnes dans leurs 
	 * zone respectives
	 */
	private void remplissage() {
		int position = vTables.size();
		String tab = table.getSelectedItem().toString();
		String col = colonne.getSelectedItem().toString();
		//String selection = tab+"."+col;
		//Si on a pas encore selectionner un champ de cette table
		if (Manager.exist(vTables, tab) == 0) {
			if ( position == 0) {
				from.setText(from.getText()+tab);
				select.setText(select.getText()+tab+"."+col);
			} else {
				from.setText(from.getText()+", "+tab);
				select.setText(select.getText()+", "+tab+"."+col);
			} 
			vTables.add(tab);
		} else {
			if (position == 0) {
				select.setText(select.getText()+tab+"."+col);
			} else {
				select.setText(select.getText()+", "+tab+"."+col);
			} 
		}
			
	}
	/**
	 * Methode permettant de construire les conditions de jointures
	 */
	public void buildJoint() {
		if (activateJoint.isSelected() && vTables.size()>1) {
			//Demande la collection de jointures au Manager
			Vector<String> jointure = Manager.getInstance().getJointures(vTables);
			//joint.setText(j.toString());
			String s = "";
			for (String string : jointure) {
				
				if (jointure.indexOf(string) == 0)
					s += "("+string+") ";
				else
					s += " AND ("+string+") ";
			}
			joint.setText(s);
		}
	}


}
