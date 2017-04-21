
import java.util.Scanner;



public class Jeu {
	private Joueur[] joueurs;
	private int maxDe;
	private int scoremax = 5;
	private Scanner sc = new Scanner(System.in);

	public Jeu(int maxDe, int nbjoueur, int scoremax) {
		joueurs = new Joueur[nbjoueur];
		this.maxDe = maxDe;
		this.scoremax = scoremax;
	}

	public void initialise(){
		for(int i=0; i<joueurs.length; i++){
			System.out.println("Nom du joueur #"+i+" :");
			String nomj = sc.nextLine();
			joueurs[i] = new Joueur(nomj);
		}
	}
	

	public boolean lanceTour(){
		boolean fin = false;
		int[] distances = new int[joueurs.length];
		
		int valeurDe = (int)(maxDe*Math.random()+1);
		/*Random rand = new Random();
		int valeurDe = rand.nextInt(maxDe);*/
		
		
		for(int i=0; i<joueurs.length; i++){
			
			int prediction;
			do
			{
			System.out.println(joueurs[i].getNom()+" à vous de jouer.");
			System.out.println("Choisissez un chiffre entre 1 et "+maxDe);
		    prediction = sc.nextInt();
			}
			while((prediction <= 0) || (prediction >maxDe));
			/*boolean ok = ((prediction >= 0) && (prediction <=maxDe));
			while(!ok){
				prediction = sc.nextInt();
				ok = ((prediction >= 0) && (prediction <maxDe));
			}*/
			
			distances[i] = Math.abs(valeurDe - prediction);
			
		}
		
		System.out.println("La valeur du dé est de "+valeurDe+".\n\n");
		
		
		for(int i=0; i<distances.length; i++){
			if(distances[i] == 0){
				joueurs[i].setScore(joueurs[i].getScore()+1);
				System.out.println("Bravo "+joueurs[i].getNom()+" vous avez bien prédit.");
			}
			if(joueurs[i].getScore() >= scoremax){
				fin = true;
			}
		}
		return fin;
	}

	public void affiche(){
		for(int i=0; i<joueurs.length; i++){
			System.out.println("Joueur "+joueurs[i].getNom()+" , score = "+joueurs[i].getScore());
			if (joueurs[i].getScore() >= scoremax){
				System.out.println("Vous avez gagn�!!!!!");
			}
		}
	}
}
