package Model.Technique;

import java.util.TimerTask;

import Controleur.Manager;

public class Commissaire  extends TimerTask{

	//private CpteRebTech rebours;
	//private Thread t;
	//private ArrayList<Courreur> tabArrivee;
	private int nbreArrivee;
	
	public Commissaire() {
		//setRebours(null);
		//t = new Thread(this);
		//tabArrivee = Manager.getInstance().tabCourreur();
		//nbreArrivee = 0;
	}
	/*
	private void lancerRebours() {
		if (rebours != null) {
			rebours.start();
		}	
	}*/
	
	public synchronized void suspend() {
		try {
			wait();
			nbreArrivee++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void lancer() {
		notifyAll();
	}
	/*
	public void setRebours(CpteRebTech rebours) {
		this.rebours = rebours;
	}
	
	public CpteRebTech getRebours() {
		return rebours;
	}
*/
	@Override
	public void run() {
		/*boolean arrivee = false;
		while (!arrivee) {
			arrivee = Manager.getInstance().sontArrivee();
			if (arrivee) {
				lancerRebours();
			}	 
		}	*/
		lancer();
	}
	
}
