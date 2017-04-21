
public class TestJeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HelloWorld!");
		Jeu j = new Jeu(5,2,1);
		j.initialise();
		
		while(!j.lanceTour()){j.affiche();}
		
	}

}
