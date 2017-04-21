package Model.Technique;

import Model.Metier.CpteReb;

public class CpteRebTech implements Runnable {
	
	private CpteReb rebours;
	private Thread t;
	
	public CpteRebTech() {
		t = new Thread(this);
		rebours = new CpteReb();
	}
	
	public void start() {
		t.start();
	}

	@Override
	public void run() {
		while (!rebours.isFini()) {
			rebours.avancer();
			//@todo AFFICHAGE du compte a rebours appel de la methode deleguée du manager
		}

	}

}
