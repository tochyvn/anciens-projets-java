package modele.technique;

import controleur.Manager;
import modele.metier.CompteRebours;
/**
 * Classe CompteRebT
 * @author TOCHAP 
 * @version v1.0
 */
public class CompteRebT implements Runnable {
	/**
	 * Represente le processus du rebours
	 */
	private Thread t;
	/**
	 * Represente le compte à rebours composant la classe technique rebours
	 */
	private CompteRebours reb;
	private static final int RATIO=1000;
	/**
	 * Constructeur de la classe technique compte à rebours
	 */
	public CompteRebT() {
		t = new Thread(this);
		reb = new CompteRebours();
	}
	/**
	 * Metthode permettant au compte à rebours de decrementer le temps qui lui est imparti
	 */
	@Override
	public void run() {
		
		while (reb.getTime() > 0) {
			Manager.getInstance().afficheRebours(reb.getTime()+"");
			reb.decTime();
			
			try {
				Thread.sleep(RATIO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * Methode permettant de lancer le Thread du compte à rebours
	 */
	public void start() {
		t.start();
	}
	
	public int getTimer() {
		return reb.getTime();
	}

}
