
import java.util.*;

/**
 * 
 * @author silnti
 *
 */
public class Jeu {
	/**
	 * @param Tableau des joueurs qui participerons à la partie
	 */
	private Joueur joueurs [];
	/**
	 * @param plateau sur lequel les joueurs se deplaçerons
	 */
	private Plateau plat; 
	Scanner sc = new Scanner (System.in);

	//CONSTRUCTEUR DU JEU
	/**
	 * Constructeur de la classe Jeu
	 * @param nbrejoueur le nombre de joueur de la partie
	 * @param nbre le nombre de case du plateau au cour du jeu
	 */
	public Jeu(int nbrejoueur,int nbre) {

		/**
		 * @param joueurs est un Tableau contenant les joueurs de la partie 
		 */
		joueurs = new Joueur [nbrejoueur];

		/**
		 * Tableau contenant des cases
		 */
		plat = new Plateau(nbre);
	}
	

	/**
	 * Cette methode permettra l'initialisation du plateau qui est en fait un tableau de Case
	 */
	public void initializePlateau() {

		plat.plateau[0] = new CaseDep("Départ");	
		plat.plateau[1] = new CaseRien("Rien");
		plat.plateau[2] = new CaseQuestions("Questions");
		plat.plateau[3] = new CaseRien("Rien");
		plat.plateau[4] = new CaseQuestions("Questions");
		plat.plateau[5] = new CaseRien("Rien");
		plat.plateau[6] = new CaseRecul("Recul");
		plat.plateau[7] = new CaseQuestions("Questions");
		plat.plateau[8] = new CaseRetDep("RetourAuDépart");
		plat.plateau[9] = new CaseArr("Arrivée");
	}

	
	/**
	 * Cette methode permettra l'initialisation de chaque joueur en saisissant leur nom respectifs
	 * 
	 */
	public void initialise(){
		for(int i=0; i<joueurs.length; i++){
			System.out.println("\nNom du joueur #"+i+" :");
			String nomj = sc.nextLine();
			joueurs[i] = new Joueur(nomj);
		}


	}

	
	/**
	 * cette methode retourne une valeur aleatoire parmi les faces du Dé
	 * @return retourne la valeur du Dé lors d'un lancé  
	 */

	public int lancerDe(){

		int valeurDe = (int)(6*Math.random()+1);
		return valeurDe;

	}

	
	/**
	 *  Cette methode permet le Deplacement du joueur sur le plateau selon la valeur lancé au De
	 *   et suivant l'effet des Cases
	 */
	public void Deplacer(){

		/**
		 * Variable permettant de determiner le joueur gagnant
		 */
		int j = 0, k = 0;

		while(j==0) {

			//CHAQUE LANCE LE DE A SON TOUR
			for (int i = 0; i < joueurs.length ; i++) {

				//POSITION AVANT LE LANCEMENT DU DE 
				System.out.println("\nAvant le lancé, "+joueurs[i].getNom()+" vous êtes à la position "+joueurs[i].getPosition());

				//DEMANDE AU JOUEUR DE LANCER LE DE
				System.out.println("LANCEMENT DU DE\n");

				/**
				 * Variable determinant si le joueur est prêt pour le lancement du Dé
				 */
				char reponse = 'N';
				do
				{
					System.out.println(joueurs[i].getNom()+" Voulez vous lancer le dé? (O/N)");

					String res = sc.nextLine();
					//pour gerer l'exeption lors de la saisie du caractère nul
					if (res.isEmpty()) 
						continue; //le test recommence au debut de la boucle do....while
					reponse = res.charAt(0);
					System.out.println("reponse = "+reponse);

				}
				while (reponse != 'O');

				/*String reponse = "NON";
				do
				{
					System.out.println(joueurs[i].getNom()+" Voulez vous lancer le dé? (O/N)");

					reponse = sc.nextLine();				    
					System.out.println("reponse = "+reponse);


				}
				while (!reponse.equals("OUI"));*/

				//VALEUR GENEREE PAR LE DE
				int de = lancerDe();

				System.out.print(joueurs[i].getNom()+" Vous avez lancé "+de);
				System.out.println(" Donc vous allez déplacer votre pion de "+de+"\n");

				//ON AJOUTE LA VALEUR DU DE A LA POSITION DU JOUEUR
				joueurs[i].setPosition(joueurs[i].getPosition()+de);
				if (joueurs[i].getPosition()< plat.plateau.length) 	
				{ System.out.println("Apres deplacement de votre pion vous serez à la case "+plat.plateau[joueurs[i].getPosition()].getNom()+" numero "+joueurs[i].getPosition());

				}

				/*teste sur la position du joueur sur le plateau pour savoir l'effet
				 * qu'il subira
				 */
				switch (joueurs[i].getPosition()){

				//CASE DEPART
				case 0 :
					System.out.println("Après vous êtes à la case "+plat.plateau[joueurs[i].getPosition()].getNom()+" Numero "+joueurs[i].getPosition());
					break;

				//CASE QUI N'A AUCUN EFFET	
				case 1 : case 3 : case 5 :
					plat.plateau[1].effet(joueurs[i]);
					System.out.println("Après effet vous êtes à la case "+plat.plateau[joueurs[i].getPosition()].getNom()+" Numero "+joueurs[i].getPosition());
					break;

				//CASE QUESTION
				case 2: case 4: case 7: 
					plat.plateau[2].effet(joueurs[i]);
					System.out.println("Après effet vous êtes à la case "+plat.plateau[joueurs[i].getPosition()].getNom()+" Numero "+joueurs[i].getPosition());        
					break;

				//CASE RECUL D'UNE CASE   
				case 6: plat.plateau[6].effet(joueurs[i]);
				System.out.println("Après effet vous êtes à la case "+plat.plateau[joueurs[i].getPosition()].getNom()+" Numero "+joueurs[i].getPosition());     
				break;

				//CASE RETOUR A LA CASE DEPART
				case 8: plat.plateau[8].effet(joueurs[i]);
				System.out.println("Après effet vous êtes à la case "+plat.plateau[joueurs[i].getPosition()].getNom()+" Numero "+joueurs[i].getPosition());      
				break;

				//CASE ARRIVEE
				case 9: plat.plateau[9].effet(joueurs[i]); 
				System.out.println("Donc vous êtes à la case "+plat.plateau[joueurs[i].getPosition()].getNom()+" Numero "+joueurs[i].getPosition());
				j++; 
				//PERMET DE SAVOIR LE PREMIER A ARRIVER SUR LA CASE ARRIVEE
				if (j==1) { 
					k=i; }

				break;

				//CASE HORS PLATEAU
				default : joueurs[i].setPosition(0);
				System.out.println("Donc vous êtes à la case "+plat.plateau[joueurs[i].getPosition()].getNom()+" Numero "+joueurs[i].getPosition());		


				}//FIN SWITCH	


			}//FIN FOR

		}//FIN WHILE

		//AFFICHAGE DU GAGNANT APRES UN NOMBRE DE LANCÉS EQUITABLES
		System.out.println("\n"+joueurs[k].getNom()+" vous etes le premier sur la case "+plat.plateau[joueurs[k].getPosition()].getNom()+ " donc Vous avez GaGné...!!!\n");

	}//FIN METHODE



	//FIN METHODE LANCERJEU()


}//FIN DE LA CLASSE

