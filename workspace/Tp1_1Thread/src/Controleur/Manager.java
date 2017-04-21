package Controleur;

import java.util.ArrayList;

import Model.Technique.Courreur;
import Vue.Vue;

public class Manager {
	/**
	 * Represente l'ensemble des courreurs participants
	 */
	private ArrayList<Courreur> courreurs;
	/**
	 * Represente la vue associ&eacute au Manager
	 */
	private Vue vue = null;
	/**
	 * Represente l'unique instance du Manager qui peut etre cr&eacutee
	 */
	private static Manager manager =null;
	/**
	 * Constructeur de la classe Manager
	 */
	private Manager() {
		courreurs = new ArrayList<Courreur>();
		initCourreur();
	}
	/**
	 * Methode permettant de Creer une instance de Manager si celle-ci n'existe pas
	 * @return represente l'instance du manager crée
	 */
	public static Manager getInstance() {
		if(manager == null)
			manager = new Manager();
		
			return manager;
	}
	/**
	 * Methode permettant au manager d'initialiser les courreurs
	 */
	private void initCourreur() {
		courreurs.add(new Courreur('A'));
		courreurs.add(new Courreur('B'));	
		courreurs.add(new Courreur('C'));
	}
	/**
	 * Methode permettant au Manager de lancer la course
	 */
	public void go() {
		
			for(int i = 0; i<courreurs.size(); i++) {
				courreurs.get(i).start();
			}
	}
	/**
	 * Methode permettant au manager de demander l'affichage à la vue
	 * si celle-ci n'est pas nulle
	 * @param carac represente le dossard du courreur
	 */
	public void affiche(String carac) {
		if (vue != null) 
			vue.affiche(carac);
	}
	/**
	 * Methode permettant au Manager de recuperer une vue associ&eacutee
	 * @return Represente la vue associ&eacutee
	 */
	public Vue getVue() {
		return vue;
	}
	/**
	 * Methode permettant au Manager de changer de vue
	 * @param vue represente la nouvelle vue
	 */
	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	

}
