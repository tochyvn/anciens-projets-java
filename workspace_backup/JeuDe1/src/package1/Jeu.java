package package1;
import java.util.*;

public class Jeu {
	
	private Joueur joueurs[];
	private De de1;
	private int scoreMax;
	Scanner sc = new Scanner(System.in);
	
	//CONSTRUCTEUR DU JEU
	public Jeu(int nbreJoueur, int maxDe, int scoreMax) {
		
		//FIXE LE NOMBRE DE JOUEURS DU JEU
		joueurs = new Joueur[nbreJoueur];
		
		//FIXE LE NOMBRE DE FACES DU DE
		de1 = new De(maxDe); 
		
		//FIXE LE SCORE MAXIMUM QUE PEUT OBTENIR UN JOUEUR
		this.scoreMax = scoreMax;
		
		//INITIALISATION DES JOUEURS
		for (int i = 0; i<joueurs.length; i++){
			
			System.out.println("Entrer le nom du joueur •"+i);
			String nomj = sc.next();
			joueurs[i] = new Joueur(nomj);	
		}
		
			
	}
	
	//LANCEMENT DU DE PAR CHAQUE ET AFFICHAGE DU SCORE APRES LANCÉ
	public boolean lancerPartie(){
		   char reponse = 'N';
		   boolean bool = false;
		for (int i = 0; i<joueurs.length; i++){
			
	        System.out.println("\nAvant le lancé, "+joueurs[i].getNom()+" votre score est "+joueurs[i].getScore());	
			System.out.println(joueurs[i].getNom()+" a vous de lancer le Dé ");
			
			//DEMANDE AU JOUEUR S'IL VEUX LANCER LE DÉ
			do{
				System.out.println(joueurs[i].getNom()+"voulez vous lancer le Dé? repondre (O/N)");
				 reponse = sc.next().charAt(0);
			}
			while(reponse != 'O');
			
			int valeurDe = de1.valeurDe();
			System.out.println(joueurs[i].getNom()+" vous venez de lancer : "+valeurDe);
			//ON VERIFIE QUE LE SCORE DE CHACUN NE DEPASSERA PAS LE SCORE MAX
			if ( (joueurs[i].getScore()+valeurDe) <=scoreMax){
							
			    joueurs[i].setScore(joueurs[i].getScore()+valeurDe);
			    System.out.println(joueurs[i].getNom()+" votre score est à present : "+joueurs[i].getScore());
			
			}//FIN IF
			else {
				System.out.println(joueurs[i].getNom()+" votre score est à present : "+joueurs[i].getScore());
				bool = true;
			}//FIN ELSE
			
			
		}//FIN FOR
		
		//AFFICHAGE FINAL DU SCORE DES JOUEURS
		for (int i = 0; i<joueurs.length; i++){
			System.out.println("\n"+joueurs[i].getNom()+" a pour score : "+joueurs[i].getScore());
		}
		
		return bool;
		
	}// FIN LANCERPARTIE()
	
	

}// FIN CLASSE
