package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
public class Chambre {
	
	
	private IntegerProperty idChambre;
	
	private StringProperty surface;
	
	private StringProperty telephone;
	
	private StringProperty etage;
	
	private StringProperty nbPlace;
	
	private IntegerProperty douche;
	
	private IntegerProperty baignoire;
	
	private IntegerProperty fumeur;
	
	private CategorieChambre categorie;
	

	public Chambre() {
		
	}
	
	/**
	 * @param id_chambre
	 * @param surface
	 * @param telephone
	 * @param etage
	 * @param nb_place
	 * @param douche
	 * @param baignoire
	 * @param fumeur
	 * @param categorie
	 */
	public Chambre(String surface, String telephone, String etage,
			String nbPlace, Integer douche, Integer baignoire, Integer fumeur,
			CategorieChambre categorie) {
		super();
		this.surface = new SimpleStringProperty(surface);
		this.telephone = new SimpleStringProperty(telephone);
		this.etage = new SimpleStringProperty(etage);
		this.nbPlace = new SimpleStringProperty(nbPlace);
		this.douche = new SimpleIntegerProperty(douche);
		this.baignoire = new SimpleIntegerProperty(baignoire);
		this.fumeur = new SimpleIntegerProperty(fumeur);
		this.categorie = categorie;
	}


	public void setIdChambre(Integer value) {
		this.idChambre = new SimpleIntegerProperty(value);
	}
	
	public int getIdChambre() {
		return idChambre.get();
	}
	
	public void setSurface(String value) {
		this.surface = new SimpleStringProperty(value);
	}
	
	public String getSurface() {
		return surface.get();
	}
	
	public void setTelephone(String value) {
		this.telephone = new SimpleStringProperty(value);
	}
	
	public String getTelephone() {
		return telephone.get();
	}
	
	public void setEtage(String value) {
		this.etage = new SimpleStringProperty(value);
	}
	
	public String getEtage() {
		return etage.get();
	}
	
	public void setNbPlace(String value) {
		this.nbPlace = new SimpleStringProperty(value);
	}
	
	public String getNbPlace() {
		return nbPlace.get();
	}

	
	public void setDouche(Integer value) {
		this.douche = new SimpleIntegerProperty(value);
	}
	
	public Integer getDouche() {
		return douche.get();
	}
	
	
	public void setBaignoire(Integer value) {
		this.baignoire = new SimpleIntegerProperty(value);
	}
	
	public Integer getBaignoire() {
		return baignoire.get();
	}
	
	public void setFumeur(Integer value) {
		this.fumeur = new SimpleIntegerProperty(value);
	}
	
	public Integer getFumeur() {
		return fumeur.get();
	}
	
	public void setCategorie(CategorieChambre value) {
		this.categorie = value;
	}
	
	public CategorieChambre getCategorie() {
		return categorie;
	}
	

	public String toString() {
		return String.valueOf(getIdChambre());
	}
	
}
