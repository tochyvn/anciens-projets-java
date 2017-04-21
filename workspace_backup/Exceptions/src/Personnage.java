
public class Personnage {

	public static void main(String[] args)  {
		
		Personne personne = null;
		try {
			personne = new Personne("TOCHAP", "LIONEL", "A");
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		} finally { 
			if (personne == null) 
				personne = new Personne();	
		  }
		
		System.out.println(personne.toString());
		
	}

}
