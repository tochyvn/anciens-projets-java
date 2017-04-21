package scolarite.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import scolarite.library.DateFormatter;
import scolarite.model.beans.Eleve;

public class EleveDAO extends DAO<Eleve> {

	public EleveDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Eleve objet) {
		String sql = "INSERT INTO ELEVE VALUES(NULL, ?, ?, ?)";
		int status = 0;
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			requete.setString(1, objet.nomProperty().get());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, DateFormatter.getDateFormatted(objet.getBirthday(), "yyyy-MM-dd"));
			status = requete.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int update(Eleve objet) {
		int status = 0;
		String sql = "UPDATE Eleve SET NOM = ?, "
				+ "PRENOM = ?, "
				+ "DATE_NAIS = ? "
				+ "WHERE ID_ELEVE = ?;";
		try {
			PreparedStatement requete = this.connexion.prepareStatement(sql);
			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, DateFormatter.getDateFormatted(objet.getBirthday(), "yyyy-MM-dd"));
			requete.setInt(4, objet.getId());
			status = requete.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean delete(Eleve objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Eleve findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAll(ObservableList<Eleve> arrayList) {
		
		String sql = "SELECT * FROM ELEVE";
		
		PreparedStatement requete;
		try {
			requete = this.connexion.prepareStatement(sql);
			ResultSet resultat = requete.executeQuery();
			while(resultat.next()) {
				Eleve eleve = new Eleve(
						resultat.getString("NOM"),
						resultat.getString("PRENOM"),
						resultat.getDate("DATE_NAIS")
				);
				System.out.println(resultat.getString("DATE_NAIS"));
				arrayList.add(eleve);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

