package Controleur;

import java.util.ArrayList;

import Model.Technique.Commissaire;
import Model.Technique.Courreur;
import Model.Technique.CpteRebTech;
import Vue.AffichageG;

public class Manager {
	/**
	 * Represente l'ensemble des courreurs participants
	 */
	private ArrayList<Courreur> courreurs;
	/**
	 * Represente la vue associ&eacute au Manager
	 */
	private AffichageG courseG;
	/**
	 * Represente l'unique instance du Manager qui peut etre cr&eacutee
	 */
	private static Manager manager =null;
	/**
	 * 
	 */
	private Commissaire commissaire;
	private CpteRebTech rebours; 
	/**
	 * Constructeur de la classe Manager
	 */
	private Manager() {
		courreurs = new ArrayList<Courreur>();
		initCourreur();
		courseG = null;
		commissaire = new Commissaire();
		rebours = new CpteRebTech();
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
		courreurs.add(new Courreur("LION", 0));
		courreurs.add(new Courreur("LIEVRE", 1));	
		courreurs.add(new Courreur("GAZELLE", 2));
		courreurs.add(new Courreur("GIRAFE", 3));
		courreurs.add(new Courreur("TORTUE", 4));
	}
	/**
	 * Methode permettant au Manager de lancer la course
	 */
	public void go() {
		
		for(int i = 0; i<courreurs.size(); i++) {
				courreurs.get(i).start();
		}
		if (sontArrivee()) {
			commissaire.lancer();
		}
	}
	
	public void attendre() {
		commissaire.suspend();
	}
	
	public void setVueG(AffichageG courseG) {
			this.courseG = courseG;
	}
	
	public void affiche1(int indice, int position, String name) {
		if (courseG != null)
			courseG.afficheProgress(indice, position, name);
	}
	
	public void affiche(int i, String s) {
		if (courseG != null)
			courseG.affiche(i, s);
	}
	
	public boolean sontArrivee() {
		boolean bool = true;
		int sum = 0; 
		for (Courreur courreur : courreurs) {
				sum+=courreur.getReady();
		}
		if (courreurs.size()==sum)
			bool=true;

		return bool;
	}
	

}
