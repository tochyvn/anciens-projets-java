package Tp3;

public class Test {
	
	static Fourmilière f;

	public static void main(String[] args) {
		
		f = new Fourmilière();
		
		for (int i = 0; i<f.vie; i++) {
			
			f.nouveauCycle();
			f.bouger();
			
			while(!BoiteMessage.getInstance().estVide()) {
				Message m=BoiteMessage.getInstance().nextMessage();
				m.getMsg();
				m.evenement();
			}
			
		}

	}

}
