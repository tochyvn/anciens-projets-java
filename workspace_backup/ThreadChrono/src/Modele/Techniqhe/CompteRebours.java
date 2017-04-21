package Modele.Techniqhe;

public class CompteRebours extends TypeChrono {

	public CompteRebours(String name, boolean sens, int timeMax,int position) {
		super(name,sens,timeMax,position);	
	}
	
	public void run() {
		
		while (h.getPosAiguille()>=0) {
			System.out.println(name+": "+h.getPosAiguille());
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
