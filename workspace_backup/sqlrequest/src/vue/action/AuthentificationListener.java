package vue.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vue.composant.FenetreConnexion;
import vue.composant.MonCombobox;

/**
 * Classe permettant d'ecouter l'item de connexion
 * @author TOCHAP
 *@version 1.0.1
 */
public class AuthentificationListener implements ActionListener {
	
	private FenetreConnexion fenetreConnexion;
	/**
	 * Constructeur de la classe
	 * @param combo represente le combobox contenant la liste des tables
	 */
	public AuthentificationListener(MonCombobox combo) {
		fenetreConnexion = new FenetreConnexion(combo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fenetreConnexion.setVisible(true);
	}

}
