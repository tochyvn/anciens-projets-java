package prodcons.modele.technique;

import prodcons.modele.metier.Producteur;

public class ProducteurT implements Runnable {
	private static final int RATIO = 70;
	private Thread t;
	private Producteur pr;
	
	public ProducteurT() {
		pr = new Producteur();
		t = new Thread(this);
	}

	public void start()
	{
		t.start();
	}
	@Override
	public void run() {
		while(!pr.isFini())
		{
			pr.poser();
			try {
				Thread.sleep((long)(Math.random()*RATIO));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public void setAp(String s)
	{
		pr.setAp(s);
	}

	public void setPanier(Panier p) {
		pr.setPanier(p);
		
	}
}
