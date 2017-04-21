package Modele.Technique;

import Controleur.HorlogesManager;
import Modele.Metier.Horloge;
/**
 * 
 * @author TOCHYVN
 *
 */
public class HorlogeT implements Runnable {
	/**
	 * Represente l'horloge
	 */
	private Horloge h;
	/**
	 * Represente le thread qui compose l'horloge
	 */
	private Thread t;
	/**
	 * Attribut permettant de mettre le thread en sommeil
	 */
	public static final long RATIO=1000;
	/**
	 * Constructeur de la classe Horloge Technique
	 * @param h represente l'horloge qui compose l'horloge technique
	 */
	public HorlogeT(Horloge h) {
		this.h = h;
		t = new Thread(this);
	}

	@Override
	public void run() {
		
		while (!h.estArrivee()) {
			
			/*Affichage en console
			HorlogesManager.getInstance().afficheConsole(h.getTime()+" ");
			*/
			
			//Affichage dans l'applet
			if (h.isChrono())
				HorlogesManager.getInstance().afficheChrono(h.getTime()+"");
			else
				HorlogesManager.getInstance().afficheRebours(h.getTime()+"");
			
			h.avancer();
			try {
				Thread.sleep(RATIO);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
	/**
	 * Methode permettant de lancer le Thread composant l'horloge technique
	 */
	public void start() {
		t.start();
	}
	/**
	 * 
	 */
	public void stop() {
		t.interrupt();
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

}
