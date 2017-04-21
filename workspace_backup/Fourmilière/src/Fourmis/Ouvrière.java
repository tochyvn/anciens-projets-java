package Fourmis;

/**
 * 
 * @author silnti
 *
 */
public class Ouvrière extends FourmiMobile {
    /**
     * 
     * @param position
     * @param cycleVie
     * @param vitesse
     */
	public Ouvrière(int position, int cycleVie, int vitesse) {
		super(position, cycleVie, vitesse);
	   
	}
    
    /**
     * 
     */
	public void deplacer() {
		this.etat = Etat.OCCUPEE;
		incrementer();
		
		
		/* AUTRE TECHNIQUE
		//on teste si la fourmi n'est pas morte, si oui elle avance d'un pas
		if ( getEtat() != Etat.INACTIVE) {
            //alors elle se deplace
			//fourmis.get(i).deplacer();
			this.etat = Etat.OCCUPEE;
			incrementer();
			System.out.println("La fourmi "+super.toString()+" et à la position "+super.getPosition());
			  //si la fourmi atteint sa cible (une fourmi ou un site)
			  if (super.getPosition() >= super.siteCible.getPositionSite()) {
		        //La fourmi change son sens de deplacement
			    super.setSens(false);	
                System.out.println("la fourmi ("+super.toString()+" ) est arrivée au site ("+super.siteCible.getNomSite()+")");
        
		      }//fin if
		      //si la fourmi arrive à la fourmilière
		      if(super.getPosition() <= 0) {
		        //elle change son sens de deplacement
			    super.setSens(true);	
                System.out.println("la fourmi "+super.toString()+" retourne à la fourmilière");
         
		}//fin if 
		}//fin if
		*/
		
	}
    


}
