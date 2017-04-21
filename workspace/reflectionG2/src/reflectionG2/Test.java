package reflectionG2;

public class Test implements Contrat{
	private int i;
	
	public Test() {
	i = 5;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	public void m1()
	{
		System.out.println("dans m1 de test");
	}

}
