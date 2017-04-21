
public class divParZero {

	public static void main(String[] args) {
		
		int j = 0, i = 0;
		
      try {
    	  System.out.println(j/i);
    	  
	} catch (ArithmeticException e) {
		  //System.out.println("ERREUR :"+e.getMessage());
		  e.printStackTrace();
	}
    finally {
    	System.out.println("Tochap&&Imane");
    }
		
	System.out.println("\n\nCoucou toi !");
		
	}
	
}
