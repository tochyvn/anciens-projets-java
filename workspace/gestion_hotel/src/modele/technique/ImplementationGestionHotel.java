package modele.technique;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import modele.metier.Etudiant;
import modele.metier.InterfaceGestionHotel;

public class ImplementationGestionHotel implements InterfaceGestionHotel {
	
	private Connection connexion;

	public ImplementationGestionHotel() {
		connexion = Connexion.getConnexion();
	}

	@Override
	public int insertEtudiant(Etudiant etudiant) {
		String sql = "INSERT INTO ETUDIANT VALUES (NULL, ?, ?, ?, ?)";
		int status = 0;
		try {
			if (connexion != null) {
				PreparedStatement requeteP = connexion.prepareStatement(sql);
				requeteP.setString(1, etudiant.getReference());
				requeteP.setString(2, etudiant.getNom());
				requeteP.setString(3, etudiant.getPrenom());
				requeteP.setString(4, etudiant.getSpecialite());
				status = requeteP.executeUpdate();
			}
			
			System.out.println(status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("erreurr lors de l'execution de la requête");
		}
		System.out.println("finally ="+status);
		return status;
	}

	@Override
	public int updateEtudiant(String reference, Etudiant etudiant) {
		String sql = "UPDATE ETUDIANT SET NOM = ?, "
				+ "PRENOM = ?, "
				+ "SPECIALITE = ? "
				+ "WHERE REFERENCE = ?";
		int status = 0;
		try {
			PreparedStatement requeteP = connexion.prepareStatement(sql);
			requeteP.setString(1, etudiant.getNom());
			requeteP.setString(2, etudiant.getPrenom());
			requeteP.setString(3, etudiant.getSpecialite());
			requeteP.setString(4, reference);
			status = requeteP.executeUpdate();
			System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}

	@Override
	public void deleteEtudiant(String reference) {
		
		String sql = "DELETE FROM ETUDIANT WHERE reference = ?";
		try {
			PreparedStatement requeteP = connexion.prepareStatement(sql);
			requeteP.setString(1, reference);
			System.out.println("Supression de l'étudiant de reference "+reference);
			int  recordNumber = requeteP.executeUpdate();
			System.out.println(recordNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Vector<Etudiant> getAllEtudiant() {
		String sql = "SELECT * FROM ETUDIANT";
		Vector<Etudiant> resultat = new Vector<Etudiant>();
		try {
			//Si la connexion s'est bien établie
			if (connexion != null) {
				PreparedStatement requete = connexion.prepareStatement(sql);
				ResultSet result = requete.executeQuery();
				while (result.next()) {
					Etudiant e = new Etudiant();
					e.setIdentifiant(result.getInt("Identifiant"));
					e.setReference(result.getString("REFERENCE"));
					e.setNom(result.getString("NOM"));
					e.setPrenom(result.getString("PRENOM"));
					e.setSpecialite(result.getString("SPECIALITE"));
					resultat.add(e);
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Un problème est survenue lors de l'établissement de la connexion\r\n"+e.getMessage());
			e.printStackTrace();
		}
		
		return resultat;
	}

	@Override
	public Vector<Vector<String>> getAllEtudiant1() {
		String sql = "SELECT * FROM ETUDIANT";
		Vector<Vector<String>> resultat = new Vector<Vector<String>>();
		try {
			PreparedStatement requete = connexion.prepareStatement(sql);
			ResultSet result = requete.executeQuery();
			while (result.next()) {
				Vector<String> e = new Vector<String>();
				//e.add(""+result.getInt("Identifiant"));
				e.add(result.getString("REFERENCE"));
				e.add(result.getString("NOM"));
				e.add(result.getString("PRENOM"));
				e.add(result.getString("SPECIALITE"));
				System.out.println(result.getString("REFERENCE")+"  "+result.getString("NOM")+"  "+result.getString("PRENOM")+"  "+result.getString("SPECIALITE"));
				resultat.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
	}

	@Override
	public boolean ifExistEtudiant(String reference) {
		boolean bool = false;
		String sql = "SELECT * FROM ETUDIANT WHERE reference = ?";
		PreparedStatement requete;
		try {
			requete = connexion.prepareStatement(sql);
			requete.setString(1, reference);
			ResultSet result = requete.executeQuery();
			if(result.next()) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bool;
	}

	

}
