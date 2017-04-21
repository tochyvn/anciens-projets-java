package Fourmis;

import Application.TestFourmiliere;
import Fourmilière.*;

 /**
  * 
  * @author silnti
  *
  */
  public class Soldat extends Fourmi {
	/**
	 * represente le site de destination d'un soldat
	 */
    private Site siteCible;
    /**
     * represente la vitesse d'un soldat
     */
    private int vitesse;
    /**
     * represente le sens de d&eacute;placement d'un soldat
     */
    private boolean sens = true;
 /**
  * Constructeur de la classe Soldat
  * @param cycleVie initialise le cycle de vie d'un soldat
  * @param vitesse initialise la vitesse d'un soldat
  */
 public Soldat(int cycleVie, int vitesse) {
	super(cycleVie);
	this.vitesse = vitesse;
}

 /**
  * methode permettant d'obtenir la valeur de la vitesse d'un soldat
  * @return retourne la valeur de la vitesse d'un soldat
  */
 public int getVitesse() {
	return vitesse;
}
 /**
  * Methode permettant de modifier la valeur de la vitesse d'un soldat
  * par la valeur entr&eacute;e en param&egrave;tre
  * @param vitesse represente la valeur &agrave; donner &agrave; la vitesse d'un soldat
  */
 public void setVitesse(int vitesse) {
	this.vitesse = vitesse;
}
 /**
  * Methode permettant d'acceder &agrave; la valeur du sens de deplacement de l'ouvri&egrave;re
  * @return retourne true si l'ouvri&egrave;re va vers son site de destination et false si elle va vers la fourmili&egrave;re
  */
 public boolean isSens() {
	return sens;
}
 /**
  * Methode permettant de modifier la valeur du sens de deplacement d'une ouvri&egrave;re
  * @param sens represente la valeur du sens &agrave; donner &agrave; l'ouvri&egrave;re
  */
 public void setSens(boolean sens) {
	this.sens = sens;
}
 /**
 * Methode permettant d'acceder &agrave; la valeur du site de destination &agrave; un soldat
 * @return retourne la valeur du site de destinatinon
 */
 public Site getSiteCible() {
	return siteCible;
}
 /**
 * Methode permettant de modifier la valeur du siteCible d'une ouvri&egrave;re
 * @param siteCible represente la valeur &agrave; donner au site de destination d'une ouvri&egrave;re
 */
 public void setSiteCible(Site siteCible) {
	this.siteCible = siteCible;
}
 @Override
 public void comportement(Fourmiliere f) {
	
		//si LIBRE
		if (etat() == Etat.LIBRE) {
			//on lui affecte un site aleatoire
		    siteCible = f.genererSiteAleatoire();
		    if (siteCible != null) {
		       //le sens est positif (vers le site de destination)
		       setSens(true);
	           //on incremente sa position
	    	   avancer();
		    }
				 
		}
		//si OCCUPEE
		else 
			if (etat() == Etat.OCCUPEE)
		       avancer();
			
		
	//}//fin if
	
}

  private void avancer() {
	//si son sens est positif 
	if (sens == true) {
		TestFourmiliere.affiche(afficheInfoFourmi()+" avance vers le site ("+siteCible.afficherSite()+")");
		setPosition(position+vitesse);
		//si l'ouvrière atteint sa cible 
		  if (position >= siteCible.getPositionSite()) {
			 position = siteCible.getPositionSite();
		     //Affichage
			 TestFourmiliere.affiche("\tRapport :le site ("+siteCible.getNomSite()+") est securisé");
			 //elle change son sens de deplacement
			 setSens(false);
			  
		   }//fin if
	}
	//sinon
	else {
		TestFourmiliere.affiche(afficheInfoFourmi()+" avance vers la fourmilière");
		setPosition(position-vitesse);
		//si la fourmi arrive à la fourmilière
		   if(position <= 0) {
			  position = 0;
		      //elle change son sens de deplacement (vers la fourmilière)
			  setSens(true);	
        
		   }//fin if 
	}
}  
	
}
