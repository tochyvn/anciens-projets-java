package Modele.Technique;

import Controleur.HorlogesManager;
import Modele.Metier.Horloge;
/**
 * Classe HorlogeJeu
 * @author TOCHYVN
 *
 */
public class HorlogeJeu implements Runnable {
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
	public HorlogeJeu(Horloge h) {
		this.h = h;
		t = new Thread(this);
	}

	@Override
	public void run() {
		
		while (!h.estArrivee()) {
			//affichage dans l'applet
			if (h.isChrono())
				HorlogesManager.getInstance().afficheChrono(h.getTime()+"");
			else
				HorlogesManager.getInstance().afficheRebours(h.getTime()+"");
			/*
			 //affichage en console
			HorlogesManager.getInstance().afficheConsole(h.getTime()+" ");
			*/
			
			h.avancer();
			
			try {
				Thread.sleep(RATIO);
			}catch (InterruptedException e) {
				HorlogesManager.getInstance().afficheChrono("Interrompu.......à "+h.getTime()+" secondes.....");
				h.setTime(h.getTimeMax()+1);
				//HorlogesManager.getInstance().afficheConsole("\nArret du "+h.getClass().getSimpleName()+" à "+h.getTime()+" secondes\n");
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
	 * Methode qui nous permettra de provoqué une exception dans un autre thread sachant qu'il y a un sleep 
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
