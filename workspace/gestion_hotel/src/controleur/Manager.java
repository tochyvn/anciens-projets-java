package controleur;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import modele.metier.Etudiant;
import modele.metier.EtudiantException;
import modele.technique.Connexion;
import modele.technique.ImplementationGestionHotel;


public class Manager {
	
	private static Manager instance;
	public static Connection connexion;
	private ImplementationGestionHotel modele;

	private Manager() {
		super();
		instance = null;
		connexion = null;
		modele = new ImplementationGestionHotel();
	}
	
	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param e
	 */
	public void addEtudiant(Etudiant e) {
		if (!modele.ifExistEtudiant(e.getReference())) {
			int status = modele.insertEtudiant(e);
			if (status == 1) {
				
				JOptionPane.showMessageDialog(null, "Insertion réussie : Reference [ "+ e.getReference() +" ]",
						"Confirmation d'insertion",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		} else {
			JOptionPane.showMessageDialog(null, "Echec d'insertion : L'&eacute;tudiant &agrave; la"
					+ " Reference [ "+ e.getReference() +" ] existe d&eacute;ja",
					"Confirmation d'insertion",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	/**
	 * 
	 * @param ref
	 * @param e
	 */
	public void updateEtudiant(String ref, Etudiant e) {
		int status = modele.updateEtudiant(ref, e);
		if (status == 1) {
			
			JOptionPane.showMessageDialog(null, "Mise à jour réussie : Reference [ "+ e.getReference() +" ]",
					"Confirmation de mise à jour",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * 
	 * @param ref
	 * @throws EtudiantException
	 */
	public void deleteEtudiant(String ref) throws EtudiantException {
		
		if (modele.ifExistEtudiant(ref)) {
			int confirmation = JOptionPane.showConfirmDialog(null, 
					"Voulez vraiment supprimer cet etudiant ? : Reference [ "+ ref +" ]",
					"Confirmation de suppression",
					JOptionPane.YES_NO_OPTION);
			if (confirmation == JOptionPane.YES_OPTION) {
				modele.deleteEtudiant(ref);
			}
		}else {
			throw new EtudiantException("L'etudiant [ "+ref+" ] n'existe pas");
		}
		
	}
	
	public Vector<Etudiant> getEtudiants() {
		
		return modele.getAllEtudiant();
	}
	
	public Vector<Vector<String>> getEtudiants1() {
		
		return modele.getAllEtudiant1();
	}
	
	public Connection getConnexion() {

/*******************************TEST CONNEXION DISTANTE**********************************************/
/*******************************TEST CONNEXION DISTANTE**********************************************/
/*******************************TEST CONNEXION DISTANTE**********************************************/
		connexion = Connexion.getConnexion();
		
		if (connexion != null) {
			try {
				
				System.out.println(connexion.getCatalog());
				DatabaseMetaData databaseMetadata = connexion.getMetaData();
				ResultSet table = databaseMetadata.getTables(null, null, "%" ,new String[] {"TABLE"});
				while(table.next()) {
					String nom = table.getString("TABLE_NAME");
					System.out.println(nom+"\r\n");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return connexion;
	}
	
/*******************************TEST CONNEXION DISTANTE**********************************************/
/*******************************TEST CONNEXION DISTANTE**********************************************/
/*******************************TEST CONNEXION DISTANTE**********************************************/
}
