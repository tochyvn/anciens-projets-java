package Controleur;

import java.util.ArrayList;

import Modele.Metier.Chrono;
import Modele.Metier.Rebours;
import Modele.Technique.HorlogeJeu;
import Modele.Technique.LaBombe;
import Modele.Technique.MonTimer;
import Vue.Affichage;
/**
 * Classe HorlogeManager
 * @author TOCHYVN
 *
 */
public class HorlogesManager {
	/**
	 * Represente un tableau d'horloge technique (Chrono ou compte a rebours thread&eacute)
	 */
	private ArrayList<HorlogeJeu> horloges;
	/**
	 * Represente la vue qui sera délegué pour l'affichage (Graphique ou console)
	 */
	private Affichage vue;
	/**
	 * Represente le manager
	 */
	private static HorlogesManager manager;
	/**
	 * Represente le planificateur d'interruption d'un thread
	 */
	private MonTimer monTimer;
	/**
	 * 
	 */
	private LaBombe maBombe;
	/**
	 * Constructeur privé du manager sans paramètre
	 */
	private HorlogesManager() {
		manager = null;
		horloges = new ArrayList<HorlogeJeu>();
		vue = null;
		this.init();
		monTimer = new MonTimer();
		maBombe = new LaBombe();
	}
	/**
	 * Constructeur avec parametre
	 * @param t represente une instance existante de la classe MonTimer (qui sera partagée)
	 * @param b represente une instance existante de la classe LaBombe (qui sera partagée)
	 */
	private HorlogesManager(MonTimer t, LaBombe b) {
		manager = null;
		horloges = new ArrayList<HorlogeJeu>();
		vue = null;
		this.init();
		monTimer = t;
		maBombe = b;
	}
	/**
	 * Methode permettant d'associer une horloge à une bombe et d'associer celle à un timer
	 */
	private void stopper() {
		maBombe.setH(horloges.get(0));
		monTimer.setBombe(maBombe);
		monTimer.programStop();
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
		horloges.add(new HorlogeJeu(new Chrono(50)));
		horloges.add(new HorlogeJeu(new Rebours(25)));
	}
	/**
	 * Methode permettant de lancer chaque horloge par leur thread
	 */
	public void lancerHorloge() {
		for (HorlogeJeu h:horloges) 
			h.start();
		this.stopper();
	}
	/**
	 * Methode permettant au manager de déleguer l'affichage du chrono à la vue
	 * @param time represente le temps actuel du chrono
	 */
	public void afficheChrono(String s) {
		if (vue != null)
			vue.afficheChr(s);	
	}
	/**
	 * Methode permettant au manager de déleguer l'affichage du Rebours a la vue 
	 * @param time represente le temps actuel du compte a rebours
	 */
	public void afficheRebours(String s) {
		if (vue != null)
			vue.afficheReb(s);
	}
	/**
	 * Methode permettant au manager de déleguer l'affichage en console a la vue  
	 * @param s la chaine representant la position
	 */
	public void afficheConsole(String s) {
		if (vue != null)
			vue.affiche(s);		
	}
	/**
	 * Methode permettant de se connecter à une vue (dans notre cas la console ou l'applet)
	 * @param vue represente la vue a connecter
	 */
	public void setVue(Affichage vue) {
		this.vue = vue;
	}
	
	public Affichage getVue() {
		return vue;
		
	}

}
