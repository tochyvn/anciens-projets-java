package Fourmis;

import java.util.ArrayList;

/**
 * 
 * @author silnti
 *
 */
public class Reine extends Fourmi{

	/**
	 * constructeur de la classe reine
	 * @param position position de la reine
	 * @param cycleVie cycle de vie de la reine
	 */
	public Reine(int position, int cycleVie) {
		super(position, cycleVie);
		
	}

	/**
	 * Action permettant de faire naitre des fourmis
	 * @param nbreOuvrière nombre d'ouvrières
	 * @param nbreSoldat nombre de soldats
	 * @param nbreSoigneur nombre de soigneurs
	 */
    public ArrayList<FourmiMobile> faitNaitre(int nbreOuvrière, int nbreSoldat, int nbreSoigneur) {
    	ArrayList<FourmiMobile> fourmis = new ArrayList<FourmiMobile>();
    	
    	//creation d'un nombre connu d'ouvrières
    	System.out.println("Naissance de "+nbreOuvrière+" ouvrières");
    	for(int i = 0; i<nbreOuvrière; i++) 
    		
    		fourmis.add(new Ouvrière(0, 1, 1));
    	
    		
    	//creation d'un nombre connu de soldats
    	System.out.println("Naissance de "+nbreSoldat+" soldats");
    	for(int i = 0; i<nbreSoldat; i++) 
    		
        	fourmis.add(new Soldat(0, 2, 2));
    	
        
        /*creation d'un nombre connu de soigneurs
    	System.out.println("Naissance de "+nbreSoigneur+" soignueurs");
        for(int i = 0; i<nbreSoigneur; i++) 
        	
        	fourmis.add(new Soigneur(0, 100, 1)); */
        	
        	
    		
    		
    	
		
        return fourmis;
    	
       }//fin fait naitre
    	

    }
