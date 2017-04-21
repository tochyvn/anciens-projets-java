package model.beans;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Eleve {
	
	private IntegerProperty id;
	private StringProperty nom;
	private StringProperty prenom;
	private ObjectProperty<LocalDate> birthday;

	public Eleve() {
		this(null, null, null);
	}
	
	public Eleve(String nom, String prenom, LocalDate birthday) {
		super();
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.birthday = new SimpleObjectProperty<LocalDate>(birthday);
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

	public void setPreom(String prenom) {
		this.nom = new SimpleStringProperty(prenom);
	}
	
	public StringProperty prenomProperty() {
		return prenom;
	}

	public LocalDate getBirthday() {
		return birthday.get();
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = new SimpleObjectProperty<LocalDate>(birthday);
	}
	
	public ObjectProperty<LocalDate> birthdayProperty() {
		return birthday;
	}

}
