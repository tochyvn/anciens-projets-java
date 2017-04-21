package exercice2;

public class Alphabet implements Runnable {
	
	public Alphabet() {
		
	}

	@Override
	public void run() {
		
		for (char car = 'A'; car <= 'Z'; car++) {
			System.out.println(car);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
