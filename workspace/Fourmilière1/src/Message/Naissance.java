package Message;

import Application.TestFourmiliere;
import Fourmilière.Fourmiliere;
import Fourmis.Fourmi;
import Fourmis.Ouvriere;
import Fourmis.Soigneur;
import Fourmis.Soldat;

public class Naissance extends Message{
	/**
	 * Represente la numerotation des ouvri&egrave;res
	 */
	public static int numOuv = 0;
	/**
	 * Represente la numerotation des soldats
	 */
	public static int numSol = 0;
	/**
	 * Represente la numerotation des soigneurs
	 */
	public static int numSoi = 0;
	/**
	 * Constructeur de la classe Naissance
	 * @param expediteur permet de preciser la fourmi qui a envoy&eacute; le message
	 */
	public Naissance(Fourmi expediteur) {
		super(expediteur);
		this.notification = TypeMessage.NAISSANCE;
	}
    @Override
	public void action(Fourmiliere f) {
		int nbreOuvrière = 2, nbreSoldat = 1, nbreSoigneur = 2;
		
	  TestFourmiliere.affiche((nbreOuvrière+nbreSoldat+nbreSoigneur)+" nouvelles fourmis arrivent dans la fourmilière:");
	  TestFourmiliere.affiche("Ouvrières : "+nbreOuvrière+"  Soldats : "+nbreSoldat+"  Soigneurs : "+nbreSoigneur);
	    
	//creation d'un nombre connu d'ouvrières
	for(int i = 1; i<=nbreOuvrière; i++) {
		
		Ouvriere ouv = new Ouvriere(4, 1);
		f.getFourmis().add(ouv);
		numOuv = numOuv + 1;
	    ouv.setNumero(numOuv);
	    
	}
		
	//creation d'un nombre connu de soldats
	for(int i = 1; i<=nbreSoldat; i++)  {
		
		Soldat sold = new Soldat(4, 2);
		f.getFourmis().add(sold);
		numSol = numSol + 1;
		sold.setNumero(numSol); 
	    
	}
	
    //creation d'un nombre connu de soigneurs
    for(int i = 1; i<=nbreSoigneur; i++) {
    	
    	Soigneur soig = new Soigneur(10, 1);
    	f.getFourmis().add(soig);
    	numSoi = numSoi + 1;
    	soig.setNumero(numSoi); 
    	
    }
    
		
	}

}
