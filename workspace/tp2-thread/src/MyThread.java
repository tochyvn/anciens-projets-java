
public class MyThread extends Thread {

	public MyThread() {

	}

	public static void main(String[] args) {
		// On crée une instance de l'objet MyThread.
		MyThread t1 = new MyThread();
		// Puis on lance le thread : t1 exécute alors la méthode run()
		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Le thread est lancer");
	}
	
}
