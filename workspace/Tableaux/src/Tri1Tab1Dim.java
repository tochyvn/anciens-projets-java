import java.util.Scanner;


public class Tri1Tab1Dim {

	public static void main(String[] args) {
		
		char tabCar[]  = {'a','b','c','d','e','f','g'};
		char car =' ', reponse = ' ';
		Scanner sc = new Scanner(System.in);
		
		
		/*boucle demandant à l'utilisateur s'il rechercher une autre valeur
		do {
			
			System.out.println("Entrer l'élément à rechercher dans le tableau :");
			car = sc.nextLine().charAt(0);
			//On parcours tout les elements du tableau
			for(int i=0; i<tabCar.length; i++)
			{
				//Teste si la valeur entrée est dans le tableau
				if (tabCar[i] == car) {
					//si oui, on affiche le message suivant
					System.out.println(car+" est un element du tableau\n");
				    break;
				}
				//sinon 
				else
					//on teste si on a parcouru tout le tableau
					if (i == tabCar.length-1)
						//on affiche le message suivant
						System.out.println(car+" ne se trouve pas dans le tableau\n");
				
			}//FIN FOR
			
		    System.out.println("Voulez vous rechercher à nouveau? repondre par (O/N)");
		    reponse = sc.nextLine().charAt(0);
		} while(reponse == 'O' );
		*/
		                        //OU
		
		int i = 0;

		//On repete cette boucle tant que l'utilisateur n'a pas rentré une valeur dans le tableau
        do { 
             System.out.println("Rentrer une lettre en minuscule, SVP");
		     car = sc.nextLine().charAt(0);
		     i = 0;
		     while (i < tabCar.length && car != tabCar[i])
		     i++;
		     //si i < à la taille du tableau, c'est que la boucle n'a pas dépassée la taille du tableau
		     if (i < tabCar.length)
		    	 System.out.println(car+" se trouve dans le tableau");
		     //sinon ( i >= tabCar.length)
		     else
		    	 System.out.println(car+" ne se trouve pas dans le tableau");
	   
          } while(i >= tabCar.length);
        
      //Tant que la lettre de l'utilisateur ne correspond pas à une lettre du tableau
        
        
	


	}

}
