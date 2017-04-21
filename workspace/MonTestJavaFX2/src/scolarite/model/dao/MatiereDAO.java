package scolarite.model.dao;

import java.sql.Connection;

import javafx.collections.ObservableList;
import scolarite.model.beans.Matiere;

public class MatiereDAO extends DAO<Matiere> {

	public MatiereDAO(Connection conn) {
		super(conn);
	}

	@Override
	public int create(Matiere objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Matiere objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Matiere objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Matiere findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAll(ObservableList<Matiere> arrayList) {
		// TODO Auto-generated method stub
		
	}

}
