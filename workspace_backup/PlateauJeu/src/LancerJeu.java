import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author silnti
 *
 */
public class LancerJeu {
	/**
	 * Ceci represente la fonction à partir de laquelle notre programme est lancé
	 * @param args
	 */
      
      /**
       * Methode contenant la fonction pour lancer notre programme 
       * @param args permettant l'affichage dans la console
       */
	public static void main(String[] args) {
		
		int a = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Entrer le nombre de joueurs participant à la partie");
			 a = sc.nextInt();
		} catch (Exception InputMismatchException) {
			
			
		}
		//intialisation du nombre de joueur de la partie
		Jeu J = new Jeu (a, 10);
		
		//INITIALISATION DU PLATEAU
		
		J.initializePlateau();
		
		//SAISIE DES JOUEURS
		J.initialise();
		
		//DEPLACEMENT DES PIONS	
	    
	    J.Deplacer();
			
	    }
	    	
		}
		

	

