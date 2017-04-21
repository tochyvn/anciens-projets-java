package modele.technique;

import controleur.Manager;
import modele.metier.Personne;
/**
 * Classe Courreur
 * @author TOCHAP 
 * @version v1.0
 */
public class Courreur implements Runnable {
	
	private Personne p;
	private Thread t;
	/**
	 * Constante representant la ligne d'arrivée de la course
	 */
	public final static int ARRIVEE=100;
	/**
	 * Constante representant la ligne de depart de la course
	 */
	public final static int DEPART=20;
	/**
	 * Constante concernant la vitesse des courreurs
	 */
	private final static int RATIO=300;
	/**
	 * Constructeur de la classe Courreur
	 * @param name nom du courreur
	 */
	public Courreur(String name) {
		p = new Personne(name);
		t = new Thread(this);
	}

	
	@Override
	public void run() {
		double oldDate = System.currentTimeMillis();
		int index = Manager.getInstance().indexCourreur(this);
		while(!isArrivee()) {
			
			Manager.getInstance().afficheProgress(index, p.getPosition(), p.getName()+" ");
			//Si le courreur est arrivé à la ligne de depart
			if (isDepart()) {
				
				Manager.getInstance().inceDepart();
				synchronized (this) {
					try {
						wait();
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			p.avancer();
			try {
				Thread.sleep((long)(Math.random()*RATIO));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		double newDate = System.currentTimeMillis();
		int current =(int)((newDate-oldDate)/1000);
		Manager.getInstance().increArrivee();
		String s = p.getName()+" A FINI AU RANG: "+Manager.getInstance().nbreArrivee()+" EN "+current+" secondes";
		Manager.getInstance().afficheProgress(index, p.getPosition(), s);
	}
	
	/**
	 * Methode permettant de lancer le Thread du courreur
	 */
	public void start() {
		t.start();
	}
	/**
	 * Methode permettant de savoir si un courreur est sur la ligne d'arrivée
	 * @return true si le courreur est sur la ligne d'arrivée et false dans le cas contraire
	 */
	private boolean isArrivee() {
		return p.getPosition() >= ARRIVEE;
	}
	/**
	 * Methode permettant de savoir si un courreur est sur la ligne de depart
	 * @return true si le courreur est sur la ligne depart et false dans le cas contraire
	 */
	public boolean isDepart() {
		return p.getPosition() == DEPART;
	}

	
}

