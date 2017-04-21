package package1;

public class TestThread extends Thread {
	public Thread t;

	public TestThread() {
		// TODO Auto-generated constructor stub
	}
	//Constructeur du thread et demarrage en parallèle
	public TestThread(String name) {
		super(name);
		System.out.println("statut du thread "+name+" = "+this.getState());
		this.start();
		System.out.println("statut du thread "+name+" = "+this.getState());
	}
	
	//Constructeur
	public TestThread(String name, Thread t) {
		super(name);
		this.t = t;
		System.out.println("statut du thread "+name+" = "+this.getState());
		this.start();
		System.out.println("statut du thread "+name+" = "+this.getState());
		
	}
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("statut du thread "+this.getName()+" = "+this.getState());
			if (t != null)
				System.out.println("statut du thread "+t.getName()+" pendant le thread "+this.getName()+" = "+t.getState());
				
		}
	}
	
	public void setThread(Thread t) {
		this.t = t;
	}

}
