package Modele.Techniqhe;

import Controleur.ChronoManager;

public class Chrono extends TypeChrono {

	public Chrono(String name, boolean sens, int timeMax,int position) {
		super(name,sens,timeMax,position);	
	}
	
	@Override
	public void run() {
		
		while (h.getPosAiguille()<=timeMax) {
			ChronoManager.getInstance().getVue().affiche(name);
			h.avancer();
			try {
				Thread.sleep((long)(Math.random()*RATIO));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
