package exercice3;

public class Personne implements Runnable {
	
	private String nom;

	public Personne(String nom) {
		this.nom = nom;
	}

	@Override
	public void run() {
		int wait = this.generateTime(0, 200);
		for(int i = 0; i < 10; i++) {
			System.out.println(nom);
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private int generateTime(int min, int max) {
		return (int) (Math.random()*(max-min)+min);
	}

}
