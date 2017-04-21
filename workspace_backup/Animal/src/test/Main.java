package test;

public class Main {

	public static void main(String[] args) {
		


		Chat b = new Chat();      b.toch();
		
		Felin a = b;
		Animal c = new Animal(); 
		c.print(b);
		c.print(a);
	}

}
