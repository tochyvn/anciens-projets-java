package vue.composant;

import javax.swing.JOptionPane;
/**
 * 
 * @author TOCHAP
 * Classe singleton pour la gestion des message d'erreur de connexion
 *
 */
public class ConnexionError {
	
	private static ConnexionError error;
	
	private ConnexionError() {
		JOptionPane.showMessageDialog(null, "Vous n'êtes pas connecté, veillez vous connecter", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static ConnexionError getConnexionError() {
		if (error == null) {
			error = new ConnexionError();
		}
		return error;
	}


}
