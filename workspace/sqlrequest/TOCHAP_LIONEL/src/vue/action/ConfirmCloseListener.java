package vue.action;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 * Classe permettant d'ecouter la fermeture de la fenetre principale de l'application
 * @author TOCHAP
 *@version 1.0.1
 */
public class ConfirmCloseListener extends WindowAdapter {
	/**
	 * Constructeur de la classe
	 */
	public ConfirmCloseListener() {
		super();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//super.windowClosing(e);
		int resultat = JOptionPane.showConfirmDialog(null, "êtes vous bien sur de vouloir quitter",
				"Quitter",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if(resultat == JOptionPane.OK_OPTION)
			System.exit(0);
	}

}
