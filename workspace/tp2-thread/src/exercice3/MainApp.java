package exercice3;

public class MainApp extends Thread {

	public static void main(String[] args) {
		MainApp main = new MainApp();
		main.start();
	}

	@Override
	public void run() {
		Personne p1 = new Personne("tochap");
		Personne p2 = new Personne("thomas");
		Personne p3 = new Personne("anonyme");
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		t1.start();
		t2.start();
		t3.start();
	}

}
