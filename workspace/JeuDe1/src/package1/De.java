package package1;

import java.util.*;


public class De {
	
	private int maxDe = 6;
	private Scanner sc = new Scanner(System.in);
	
	//CONSTRUCTEUR DE LA CLASSE DE
	public De(int maxDe){
		
		
		this.maxDe = maxDe;
	}
	
	/*ACCESSEURS
	public int getMaxDe() {
		return maxDe;
	}



	public void setMaxDe(int maxDe) {
		this.maxDe = maxDe;
	}



	//VERIFICATION DE L'INTERVALLE DE LA VALEUR SAISIE (< MAX)
	private int verifier(int x){
		
		do{
		System.out.println("Entrer une valeur comprise entre 1 et "+this.maxDe);
		x = sc.nextInt();
		}
		while(x<1 && x>6);
		
		//RETOURNER LA VA SAISIE
		return x;
		
	}*/
	
	public int valeurDe(){
		
		int valeurDe = (int)(maxDe*Math.random())+1;
		return valeurDe;
	}
}
