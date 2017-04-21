package Controleur;

import java.util.ArrayList;

import Modele.Metier.Chrono;
import Modele.Metier.Rebours;
import Modele.Technique.HorlogeT;
import Vue.Affichage;
/**
 * Classe manager
 * @author TOCHYVN
 *
 */
public class HorlogesManager {
	/**
	 * Represente un tableau d'horloge technique (Chrono ou compte a rebours thread&eacute)
	 */
	private ArrayList<HorlogeT> horloges;
	/**
	 * Represente la vue qui sera délegué pour l'affichage (Graphique ou console)
	 */
	private Affichage vue;
	/**
	 * Represente le manager
	 */
	private static HorlogesManager manager=null;
	/**
	 * Constructeur du manager
	 */
	public HorlogesManager() {
		horloges = new ArrayList<HorlogeT>();
		vue = null;
		this.init();	
	}
	/**
	 * Methode permettant de communiquer avec la classe HorlogeManager de partout
	 * @return retourne un objet de type HorlogeManager
	 */
	public static HorlogesManager getInstance() {
		if (manager == null)
			manager = new HorlogesManager();
		return manager;
		
	}
	/**
	 * Methode permettant de donner le temps a decompte de chaque horloge
	 */
	private void init() {
		horloges.add(new HorlogeT(new Chrono(10)));
		horloges.add(new HorlogeT(new Rebours(10)));
	}
	/**
	 * Methode permettant de lancer chaque horloge
	 */
	public void lancerHorloge() {
		for (HorlogeT h:horloges) 
			h.start();
	}
	/**
	 * Methode permettant au manager de demander a la vue d'afficher le chrono
	 * @param time represente le temps actuel du chrono
	 */
	public void afficheChrono(String s) {
		if (vue != null)
			vue.afficheChr(s);
			
	}
	/**
	 * Methode permettant au manager de demander a la vue d'afficher le compte a rebours
	 * @param time represente le temps actuel du compte a rebours
	 */
	public void afficheRebours(String s) {
		if (vue != null)
			vue.afficheReb(s);
			
	}
	/**
	 * Methode permettant au manager de demander a la vue d'afficher le chrono et le compte a rebours 
	 * dans la console
	 * @param s la chaine representant la position
	 */
	public void afficheConsole(String s) {
		if (vue != null)
			vue.affiche(s);
			
	}
	/**
	 * Methode permettant de connecter une vue (console ou l'applet)
	 * @param vue represente la vue a connecter
	 */
	public void setVue(Affichage vue) {
		this.vue = vue;
	}

}
