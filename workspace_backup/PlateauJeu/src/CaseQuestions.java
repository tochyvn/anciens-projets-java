
import java.util.*;
/**
 * 
 * @author silnti
 *
 */
public class CaseQuestions extends Case{
	/**
	 * Constructeur de la class CaseQuestions derivant de la classe Case
	 * @param nom represente le nom de la case
	 */
	public CaseQuestions(String nom) {
		super(nom);
		}
    /**
     * Cette methode a pour effet de questionner le joueur et selon sa reponse,
     * l'effet influencera sur position
     */
	public void effet(Joueur joueur){
		
		System.out.println("Vous allez repondre à la Question suivante ");
        System.out.println("Si vous repondez vrai, vous restez à cette case");
        System.out.println("Si vous repondez faux, vous reculerez de 2 cases");
		
		String questions[] = new String[6];
		String reponses[] = new String [6];
		String reponse = new String();
		 Scanner sc = new Scanner(System.in);
		                
		 
		 		
		               int numeroquestion= (int) (Math.random() * 6);
		               
		                //PILE DE QUESTIONS
		                questions[0] = "Combien y a t-il eu de president au cameroun?";
		                reponses[0] = "2";
		                questions[1] = "Quelle est le nom de l'ex président français?";
		                reponses[1]= "NICOLAS SARKOZY";
		                questions[2] = "Quelle est le nom du premier president du Cameroun?";
		                reponses[2] = "PAUL BIYA";
		                questions[3] = "En quelle année le cameroun a t-il eu son indépendance?";
		                reponses[3] = "1960";
		                questions[4] = "Quelle est surnom du professeur de JAVA?";
		                reponses[4] = "DESIGN PATTERN PONT";
		                questions[5] = "Combien font 5^2";
		                reponses[5] = "25";
		               
		                System.out.println("Question n°"+numeroquestion+" : " +questions[numeroquestion]);
		                reponse = sc.nextLine().toUpperCase();
		                
		                //TEST DE REPONSE
		                if (reponse.equals(reponses[numeroquestion])){
		                        System.out.println("bonne réponse");
		                       
		                        
		                }
		                else {
		                        System.out.println("mauvaise réponse, vous reculez de deux cases");
		                        //LE JOUEUR RETOURNE DE DEUX CASE                  
		                		joueur.setPosition(joueur.getPosition()-2);
		                		
		                }
		
		
	}

}

