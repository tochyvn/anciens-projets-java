package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Categories {
	
	private IntegerProperty idCategorie;
	
	private StringProperty libelle;
	
	
	public Categories() {
		
	}
	
	
	
	/**
	 * @param idCategorie
	 * @param libelle
	 */
	public Categories(Integer idCategorie, String libelle) {
		super();
		this.idCategorie = new SimpleIntegerProperty(idCategorie);
		this.libelle = new SimpleStringProperty(libelle);
	}



	public void setidCategorie(Integer value) {
		this.idCategorie = new SimpleIntegerProperty(value);
	}
	
	public int getidCategorie() {
		return idCategorie.get();
	}
	
	public IntegerProperty idCategorieProperty() {
		return idCategorie;
	}
	
	
	public void setLibelle(String value) {
		this.libelle = new SimpleStringProperty(value);
	}
	
	public String getLibelle() {
		return libelle.get();
	}
	
	public StringProperty libelleProperty() {
		return libelle;
	}
	
	public String toString() {
		return String.valueOf(getidCategorie());
	}
	
}
