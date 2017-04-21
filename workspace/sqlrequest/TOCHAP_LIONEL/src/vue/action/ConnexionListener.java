package vue.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controleur.Manager;
import vue.composant.FenetreConnexion;
import vue.composant.MonCombobox;
import vue.composant.MonComboboxModel;

/**
 * Classe permettant d'ecouter le bouton de connexion sur la fenetre principale
 * @author TOCHAP
 *@version 1.0.1
 */
public class ConnexionListener extends MouseAdapter {
	private MonCombobox combo;
	private JTextField user;
	private JTextField passwd;
	private FenetreConnexion fenetreConnexion;
	private MonCombobox driver;
	private MonCombobox database;
	/**
	 * Constructeur de la classe 
	 * @param combo represente la zone contenant la liste des tables
	 * @param driver represente la zone contenant la liste des drivers
	 * @param database represente la zone contenant la liste des bases de données
	 * @param user represente la zone contenant le nom de l'utilisateur
	 * @param passwd represente la zone contenant le mot de passe de l'utilisateur
	 * @param fenetreConnexion represente la fenetre de connexion
	 */
	public ConnexionListener(MonCombobox combo, MonCombobox driver, MonCombobox database,
			JTextField user, JTextField  passwd, FenetreConnexion fenetreConnexion) {
		this.combo = combo;
		this.user = user;
		this.passwd = passwd;
		this.fenetreConnexion = fenetreConnexion;
		this.driver = driver;
		this.database = database;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
		//Construction de la chaine de connexion
		String url = Manager.getDriver(driver.getSelectedItem().toString())+database.getSelectedItem().toString();
		System.out.println(Manager.getDriver(driver.getSelectedItem().toString())+database.getSelectedItem().toString());
		Manager.getInstance().getConnexion(url, user.getText(), passwd.getText());
		//Si la connexion est etablie
		if (Manager.conn != null){
			//On recupere la liste des tables
			Vector<String> lesNoms = Manager.getInstance().getMesTables();
			lesNoms.add(0, "Tables");
			MonComboboxModel model = new MonComboboxModel(lesNoms);
			combo.setModel(model);
			fenetreConnexion.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null,
					"Problème lors de l'établissement de la connexion, verifier les informations saisies",
					"Problème d'authentifiction", JOptionPane.ERROR_MESSAGE);
		}
	}

	

}
