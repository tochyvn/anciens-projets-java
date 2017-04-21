package Modele.Techniqhe;
import Modele.Metier.Horloge;

public abstract class TypeChrono implements Runnable{
	protected Thread t;
	protected Horloge h;
	protected int timeMax;
	protected String name;
	public final static long RATIO=1000;
	
	public TypeChrono(String name,boolean sens,int timeMax,int position) {
		t = new Thread(this);
		h = new Horloge(sens,position);
		this.name = name;
		this.timeMax = timeMax;
	}
/*
	@Override
	public void run() {
		
		while (h.getPosAiguille()<timeMax) {
			System.out.println(name+": "+h.getPosAiguille());
			h.avancer();
			try {
				Thread.sleep((long)(Math.random()*RATIO));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}*/
	
	public void start() {
		t.start();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
