package package1;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		TestThread t1 = new TestThread("A");
		TestThread t2 = new TestThread(" B",t1);

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
			System.out.println("statut du thread " + t1.getName() + " = " +t1.getState());
			System.out.println("statut du thread " + t2.getName() + " = " +t2.getState());
			
	}

}
