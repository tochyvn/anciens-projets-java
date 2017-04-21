package Model.Technique;

import java.util.TimerTask;

import Controleur.Manager;
import Model.Metier.Personne;

public class Courreur extends TimerTask /*implements Runnable*/ {
	private Personne p;
	private Thread t;
	public final static int ARRIVEE=100;
	public final static int RATIO=50;
	
	public Courreur(char dossard) {
		p = new Personne(dossard);
		t = new Thread(this);
	}

	@Override
	public void run() {
		while(p.getPosition()<ARRIVEE) {
			Manager.getInstance().affiche(""+p.getDossard());
			p.avancer();
			try {
				Thread.sleep((long) (Math.random()*RATIO));;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	Manager.getInstance().affiche("\nLe courreur de dossard "+p.getDossard()+" a fini");	
	}
	
	public void start() {
		t.start();
	}

}

