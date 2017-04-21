package vue.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JTextField;

import vue.composant.MonCombobox;

/**
 * Classe permettant de reinitialiser toutes les zones
 * @author TOCHAP
 *@version 1.0.1
 */
public class RazListener implements ActionListener {
	
	private JTextField select;
	private JTextField from;
	private JEditorPane where1;
	private JTextField where2;
	private MonCombobox combo;
	private MonCombobox combo1;
	/**
	 * Constructeur de la classe
	 * @param select select represente la zone de selection des colonnes
	 * @param from represente la zone de specification des tables intervenants dans la selection
	 * @param where1 represente la zone de jointures concernant les tables specifiées
	 * @param where2 represente la zone de restriction personnalisé
	 * @param combo represente la zone de selection des tables 
	 * @param combo1 represente la zone de selection des colonnes
	 */
	public RazListener(JTextField select, JTextField from, JEditorPane where1,
			JTextField where2, MonCombobox combo, MonCombobox combo1) {
		this.select = select;
		this.from =from;
		this.where1 = where1;
		this.where2 = where2;
		this.combo = combo;
		this.combo1 = combo1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		select.setText("");
		from.setText("");
		where1.setText("");
		where2.setText("");
		combo.setSelectedIndex(0);
		combo1.setSelectedIndex(0);
		ItemSelectColonne.getV().removeAllElements();
	}

}
