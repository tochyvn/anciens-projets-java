package prodcons.modele.technique;

import prodcons.controleur.Manager;
import prodcons.modele.metier.Consommateur;

public class ConsommateurT implements Runnable {
	private Consommateur cons;
	private Thread t;
	public static final int RATIO=100;
	public ConsommateurT() {
		cons = new Consommateur();
		t = new Thread(this);
	}

	@Override
	public void run() {
		char ret = ' ';
		while(!cons.isFini())
		{
			ret = cons.prendre();
			Manager.getInstance().afficher(ret);
			try {
				Thread.sleep((long)(Math.random()*RATIO));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setAConsommer(int c)
	{
		cons.setaConsommer(c);
	}

	public void setPanier(Panier p) {
		cons.setPanier(p);
		
	}

	public void start() {
		t.start();
		
	}
}
