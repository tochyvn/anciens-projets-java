package scolarite.model.beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Matiere {
	
	private IntegerProperty identifiant;
	private StringProperty nom;
	
	public Matiere(Integer id, String nom) {
		this.identifiant = new SimpleIntegerProperty(id);
		this.nom = new SimpleStringProperty(nom);
	}

	public Integer getIdentifiant() {
		return identifiant.get();
	}

	public void setIdentifiant(Integer identifiant) {
		this.identifiant = new SimpleIntegerProperty(identifiant);
	}
	
	public IntegerProperty identifiant() {
		return identifiant;
	}

	public String getNom() {
		return nom.get();
	}
	
	public StringProperty nom() {
		return nom;
	}

	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

}
