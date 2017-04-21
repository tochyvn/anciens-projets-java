package doubl;

public class Test {
	
public static double factorielle (double n) { 
	
	if ( n == 0 ) {
		return 1.0;
	}
	 return  n*factorielle(n-1); 

}

public static void main (String []args) {
	
	double  res =factorielle(5);
	System.out.println(res);
}

}



