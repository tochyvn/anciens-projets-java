package package1;

public class Test2 extends Thread {

	public Test2() {
		// TODO Auto-generated constructor stub
	}

	public Test2(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Test2 t = new Test2("thread en sommeil");
		t.start();
	}

	@Override
	public void run() {
		
		for (int i=0; i<20; i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getMessage();
			}
			if (i==10)
			 return;
			
		}
	}
	
	

}
