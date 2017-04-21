package Model.Technique;

import Controleur.Manager;
import Model.Metier.Personne;

public class Courreur implements Runnable {
	private Personne p;
	private Thread t;
	private int id;
	public final static int ARRIVEE=100;
	public final static int DEPART=20;
	public final static int RATIO=300;
	private int ready;
	
	
	public Courreur(String name, int id) {
		p = new Personne(name);
		t = new Thread(this);
		this.id = id;
		setReady(0);
	}

	
	@Override
	public void run() {
		long oldDate = System.currentTimeMillis();
		while(!isArrivee()) {
			
			if (p.getPosition() == DEPART) {
				setReady(1);
				Manager.getInstance().attendre();
				p.setPosition(DEPART+1);
			}
			Manager.getInstance().affiche1(id, p.getPosition(), p.getName()+" ");
			p.avancer();
			try {
				Thread.sleep((long)(Math.random()*RATIO));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long newDate = System.currentTimeMillis();
		int current =(int)((newDate-oldDate)/1000);
		Manager.getInstance().affiche(id,current+" secondes ");
	}
	
	
	public void start() {
		t.start();
	}
	
	private boolean isArrivee() {
		return p.getPosition()>ARRIVEE;
	}
	
	public boolean isDepart() {
		
		return p.getPosition() == DEPART;
		
	}


	public int getReady() {
		return ready;
	}


	public void setReady(int ready) {
		this.ready = ready;
	}
	
	
}

