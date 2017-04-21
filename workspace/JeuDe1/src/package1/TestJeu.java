package package1;

import java.util.Scanner;

public class TestJeu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*System.out.println("HELLO WORD");
		System.out.println("Entrer le nombre de joueurs participants à la partie : ");
		int a = sc.nextInt();
		System.out.println("Entrer le nombre de faces du dé : ");
		int b = sc.nextInt();
		System.out.println("Entrer le score max que ne doivent pas depasser les joueurs : ");
		int c = sc.nextInt();*/
		
		//ON DEFINIT: LE NOMBRE 
		Jeu jeu1 = new Jeu(2,6,12);
		while(jeu1.lancerPartie() != true){
			
		}
			
		
		

	}

}
