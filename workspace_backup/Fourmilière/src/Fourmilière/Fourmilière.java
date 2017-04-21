package Fourmilière;


import java.util.ArrayList;

import Fourmis.*;


/**
 * 
 * @author silnti
 *
 */
public class Fourmilière {
	
	private Site []sites = new Site[5];
	private Reine reine; 
	private ArrayList<FourmiMobile> fourmis = new ArrayList<FourmiMobile>();
	
	/**
	 * Constructeur de la classe Fourmilière
	 * @param sites
	 * @param reine
	 * @param fourmis
	 */
	public Fourmilière() {
		//creation d'une reine
	    Reine reine = new Reine(0, 5);
	    //initialisation des sites
		initSite();
		//la reine fait naitre une portion de fourmis
		fourmis = reine.faitNaitre(2, 2, 0);
		
	}
	
    /**
     * Methode permettent l'initialisation des differents sites de nourriture
     */
	private void initSite() {
		sites[0] = new Site("SITE N°1", 10, 1000, "sucre");
		sites[1] = new Site("SITE N°2", 20, 1000, "sucre");
		sites[2] = new Site("SITE N°3", 30, 1000, "sucre");
		sites[3] = new Site("SITE N°4", 40, 1000, "sucre");
		sites[4] = new Site("SITE N°5", 50, 1000, "sucre");	
	}
    /**
     * Methode generant un site aleatoire parmis les 5 disponibles
     * @return
     */
	private Site genererSiteAleatoire() {
	   
		int x = (int)(5*Math.random());
		return sites[x];
			
	}
	
    public void nouveau() {
        
    	testeVie();
    	donneDestination();
    	for (int j = 1; j<=10; j++) 
    		//chaque fourmi avance d'un pas à ça vitesse
    		avanceUnPas();
    	//On parcours le tableau de fourmis mobile
    	for(int i = 0; i<fourmis.size(); i++) {
    		// A la fin du cycle le cycle de vie de la fourmi diminue d'une unité
    		//si le cycle de vie
    		if (fourmis.get(i).getEtat() != Etat.INACTIVE) {
    		fourmis.get(i).setCycleVie(fourmis.get(i).getCycleVie()-1);
    		System.out.println("le cycle de vie de la fourmi "+fourmis.get(i).toString()+" "+i+" est de "+fourmis.get(i).getCycleVie());
    		}//fin if
    	}//fin for
    	
   }//fin nouveau
    /**
     * Methode permettant d'avancer chaque fourmi mobile d'un pas et à sa vitesse
     */
    private void avanceUnPas() {
    	//On parcours le tableau de fourmis mobile
    	for(int i = 0; i<fourmis.size(); i++) {
    		//on teste si la fourmi n'est pas morte
    		if ( fourmis.get(i).getEtat() != Etat.INACTIVE) {
                //alors elle se deplace
    			fourmis.get(i).deplacer();
				System.out.println("La fourmi "+fourmis.get(i).toString()+" "+i+" est à la position "+fourmis.get(i).getPosition());
				  //si la fourmi atteint sa cible (une fourmi ou un site) aussi si il depasse sa cible(alors on considère que sa position est egale à celle du site) 
				  if (fourmis.get(i).getPosition() >= fourmis.get(i).siteCible.getPositionSite()) {
			        //La fourmi change son sens de deplacement
				    fourmis.get(i).setSens(false);	
	                System.out.println("la fourmi ("+fourmis.get(i).toString()+" "+i+") est arrivée au site ("+fourmis.get(i).siteCible.getNomSite()+")");
	        
			      }//fin if
			      //si la fourmi arrive à la fourmilière
			      if (fourmis.get(i).getPosition() <= 0) {
			        //elle change son sens de deplacement
				    fourmis.get(i).setSens(true);	
	                System.out.println("la fourmi "+fourmis.get(i).toString()+" "+i+" retourne à la fourmilière");
	         
			}//fin if 
    		}//fin if
    		
    		
    	}//fin for
    	
    }//fin methode
      /**
       * Methode permettant de mettre l'etat à INACTIVE de toute les fourmis mortes 
       */
      private void testeVie() {
    	  //On parcours le tableau de fourmis mobile
    	  for (int i = 0; i<fourmis.size(); i++) {
    		  //on teste si la vie est O
    		  if (fourmis.get(i).getCycleVie() == 0) {
    			  fourmis.get(i).setEtat(Etat.INACTIVE);
    			  
    		  }//fin if	  
    	  }//fin for
    	
      }//fin methode
      /**
       * Methode permettant de donner une destination à une fourmi dont l'etat est "LIBRE"
       */
      private void donneDestination() {
    	  
    	  for (int i = 0; i<fourmis.size(); i++) {
    		 //si l'etat de la fourmi est egale a "LIBRE" 
    		 if (fourmis.get(i).getEtat() == Etat.LIBRE ) {
    			      //on genere un site aleatoire
    			      Site A = genererSiteAleatoire();
    			      //on affecte se site aleatoire comme cible de la fourmi
    			      fourmis.get(i).siteCible = A;
    			      System.out.println("la fourmi ("+fourmis.get(i).toString()+" "+i+") va vers le site ("+A.getNomSite()+")");
    		 }//if 
    	  }//fin for
      }//fin methode
		
}
    
	
	