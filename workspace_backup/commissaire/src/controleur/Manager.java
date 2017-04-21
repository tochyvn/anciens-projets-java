package controleur;

import java.util.ArrayList;

import vue.Affichage;
import modele.technique.Commissaire;
import modele.technique.CompteRebT;
import modele.technique.Courreur;
/**
 * Classe Manager
 * @author TOCHAP
 * @version v1.0
 */
public class Manager {

	private ArrayList<Courreur> courreurs;
	private Commissaire com;
	private CompteRebT cpteReb;
	private int nbreDepart;
	private int nbreArrivee;
	private static Manager instance;
	private Affichage vue;
	
	
	private Manager() {
		setVue(null);
		courreurs = new ArrayList<Courreur>();
		com = new Commissaire();
		nbreDepart = 0;
		nbreArrivee = 0;
		instance = null;
		cpteReb = new CompteRebT();
		//this.inialiseRunner();
	}
	
	public static Manager getInstance() {
		if (instance == null)
			instance = new Manager();
		return instance;
	}
	/**
	 * Methode permettant le lancement de la course
	 */
	public void go() {
		//On associe un compte à rebours au commissaire de la course
		com.setCpteReb(cpteReb);
		com.start();
		
		for (int i = 0; i < courreurs.size(); i++) {
			courreurs.get(i).start();
		}
	}
	/**
	 * Methode permettant d'initialiser les courreurs prenant son nom en paramètre
	 * @param s nom du courreur
	 */
	public void initialize(String s) {
		courreurs.add(new Courreur(s));
		
	}
	
	/**
	 * Methode permettant de recuperer l'index d'un courreur dans la collection
	 * @param c le courreur
	 * @return l'index du courreur dans la collection
	 */
	public int indexCourreur(Courreur c) {		
		return courreurs.indexOf(c);	
	}
	/**
	 * Methode deleguant l'affichage des barres de progressions à vue
	 * @param id index du courreur 
	 * @param position position du courreur
	 * @param name nom du courreur
	 */
	public void afficheProgress(int id, int position, String name) {
		if (vue != null)
			vue.afficheProgress(id, position, name);
	}
	/**
	 * Methode deleguant l'affichage du compte à rebours à la vue
	 * @param s le temps à afficher
	 */
	public void afficheRebours(String s) {
		if (vue != null)
			vue.affichageRebours(s);
	}
	
	public int nbreDepart() {
		return nbreDepart;
	}
	
	public int nbreArrivee() {
		return nbreArrivee;
	}
	/**
	 * Methode permettant d'incrementer le nombre de courreurs sur la ligne de depart
	 */
	public void inceDepart() {
		nbreDepart++;
	}
	/**
	 * Methode permettant d'incrementer le nombre de courreurs ayant fini la course
	 */
	public void increArrivee() {
		nbreArrivee++;
	}
	/**
	 * Methode permettant de recuperer le nombre de courreurs
	 * @return represente le nombre de courreurs
	 */
	public int courreursLength() {
		return courreurs.size();	
	}
	/**
	 * Methode permettant de reinitiliser le nombre de courreurs sur la ligne de depart
	 */
	public void reset() {
		nbreDepart = 0;
	}
	/**
	 * Methode permettant de relancer les courreurs après etre arrivés sur la ligne de depart
	 */
	public void restart() {
		for (int i = 0; i < courreurs.size(); i++) {
			synchronized(courreurs.get(i)){
				courreurs.get(i).notify();
			}
		}
	}
	/**
	 * Methode permettant d'associer une vue au manager
	 * @param vue vue à associer
	 */
	public void setVue(Affichage vue) {
		this.vue = vue;
	}
	public Affichage getVue() {
		return vue;
		
	}

}
