package scolarite.model.beans;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import scolarite.library.DateFormatter;

public class Eleve {
	
	private IntegerProperty id;
	private StringProperty nom;
	private StringProperty prenom;
	private Date birthday;
	/**
	 * Pour stocker la date au format français
	 */
	private StringProperty frenchDate;
	/**
	 *Pour stocker le nom complet
	 */
	private StringProperty nomComplet;

	public Eleve() {
		this(null, null, null);
	}
	
	public Eleve(String nom, String prenom, Date birthday) {
		super();
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.birthday = birthday;
		this.setNomComplet(nom+"++"+prenom);
		this.frenchDate = new SimpleStringProperty(DateFormatter.getDateFormatted(birthday, "dd/MM/yyyy"));
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}
	
	public IntegerProperty id() {
		return id;
	}

	public String getNom() {
		return nom.get();
	}

	public void setNom(String nom) {
		this.nom = new SimpleStringProperty(nom);
	}
	
	public StringProperty nomProperty() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom.get();
	}

	public void setPrenom(String prenom) {
		this.nom = new SimpleStringProperty(prenom);
	}
	
	public StringProperty prenomProperty() {
		return prenom;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public StringProperty nomCompletProperty() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = new SimpleStringProperty(nomComplet);
	}
	
	public String getNomCompletProperty() {
		return nomComplet.get();
	}

	public StringProperty frenchDate() {
		return frenchDate;
	}
	
	public String getFrenchDate() {
		return frenchDate.get();
	}

	public void setFrenchDate(StringProperty frenchDate) {
		this.frenchDate = frenchDate;
	}

	@Override
	public String toString() {
		
		return this.nom+" "+this.prenom+" "+this.birthday;
	}
	
	
	
}

