package exercice2;

public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Alphabet a = new Alphabet();
		Nombre n = new Nombre();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(n);
		t1.start();
		t2.start();
	}

}
