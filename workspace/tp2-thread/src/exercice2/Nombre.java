package exercice2;

public class Nombre implements Runnable {

	public Nombre() {
		
	}

	@Override
	public void run() {
		for (int i = 0; i < 26; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
