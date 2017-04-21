
public class Personne {
	String nom;
	String prenom;
	String age;
	
	public Personne(String nom, String prenom, String age) throws AgeException {
		
		if (age == "A") 
			throw new AgeException(age);
		else {
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
			this.afficher();
		}
	}
	
	public Personne() {
		
	}

	public void afficher() {
		
		System.out.println(nom+" "+prenom+" a pour age: "+age);
		
	}

}
