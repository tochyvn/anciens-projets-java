package model.dao;

import java.sql.Connection;

import javafx.collections.ObservableList;
import model.beans.Eleve;

public class EleveDAO extends DAO<Eleve> {

	public EleveDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Eleve objet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Eleve objet) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
	}
	

}
