package modele.metier;

import javax.swing.JOptionPane;

public class EtudiantException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7511363202617626120L;

	public EtudiantException(String errorMessage) {
		super();
		JOptionPane.showMessageDialog(null, errorMessage, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
}
