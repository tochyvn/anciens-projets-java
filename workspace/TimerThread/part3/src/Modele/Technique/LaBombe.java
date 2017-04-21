package Modele.Technique;

import java.util.TimerTask;

public class LaBombe extends TimerTask {
	private HorlogeJeu ht;
	
	public LaBombe() {
		this.ht = null;
	}

	@Override
	public void run() {
		if (ht != null) 
			ht.stop(); 
	}

	public HorlogeJeu getH() {
		return ht;
	}

	public void setH(HorlogeJeu ht) {
		this.ht = ht;
	}

}
