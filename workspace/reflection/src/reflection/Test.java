package reflection;

public class Test {
	private int i;
	public Test() {
		setI(0);
		
	}
	public void m1()
	{
		System.out.println("dans m1....");
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

}
