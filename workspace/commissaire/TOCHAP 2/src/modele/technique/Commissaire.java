package modele.technique;

import controleur.Manager;
/**
 * Classe Commissaire
 * @author TOCHAP 
 * @version v1.0
 */
public class Commissaire implements Runnable{
	/**
	 * Represente le compte à rebours associé au commissaire à l'arrivée des 
	 * courreurs sur la ligne de depart
	 */
	private CompteRebT cpteReb;
	/**
	 * Represente le thread du commissaire
	 */
	private Thread t;
	/**
	 * Constructeur de la classe Commissaire
	 */
	public Commissaire() {
		t = new Thread(this);
		cpteReb = null;
	}
	/**
	 * Methode permettant au commissaire de donner le depart de la course une fois tout les courreurs sur la ligne d'arrivée
	 */
	@Override
	public void run() {
		//Tant que tout les courreurs n'ont pas fini la course
		while (Manager.getInstance().nbreArrivee() < Manager.getInstance().courreursLength()) {
			//si tout les courreurs sont sur la ligne de depart le commissaire lance le compte à rebours 
			if (Manager.getInstance().nbreDepart() == Manager.getInstance().courreursLength()) {
				this.launchReb();
				Manager.getInstance().reset();
			}	
			//Si le rebours est epuisé
			if (cpteReb.getTimer() == 0) {
				Manager.getInstance().restart();
				//Manager.getInstance().
				Manager.getInstance().afficheRebours("Partez");
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Manager.getInstance().afficheRebours("Course terminée");
	}
	/**
	 * Methode permettant au commissaire de lancer le compte à rebours
	 */
	private void launchReb() {
		if (cpteReb != null)
			cpteReb.start();
	}
	/**
	 * Methode permettant de lancer le thread du commissaire
	 */
	public void start() {
		t.start();
	}
	/**
	 * Methode permettant d'associer un compte à rebours au commissaire
	 * @param cpteReb le compte à rebours à associer
	 */
	public void setCpteReb(CompteRebT cpteReb) {
		this.cpteReb = cpteReb;
	}
	

	

}
