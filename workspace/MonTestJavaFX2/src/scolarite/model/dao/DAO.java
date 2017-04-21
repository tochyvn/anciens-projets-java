package scolarite.model.dao;

import java.sql.Connection;

import javafx.collections.ObservableList;

/**
 * @author silnti
 *
 */
public abstract class DAO<T> {
	
	protected Connection connexion = null;

	/**
	 * 
	 */
	public DAO(Connection conn) {
		this.connexion = conn;
	}
	
	public abstract int create(T objet);
	
	public abstract int update(T objet);
	
	public abstract boolean delete(T objet);
	
	public abstract T findById(int id);
	
	public abstract void findAll(ObservableList<T> arrayList);

}
