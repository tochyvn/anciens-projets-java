
public class Cedric {

	public static void f(int n, int m) {
		
		if(n>0) {
			System.out.println(n+" "+m);
			f(n-2,m+1);
			System.out.println(n+" "+m);
		}
	}

	public static void main(String[] args) {
		
		Cedric.f(6,3);

	}

}
