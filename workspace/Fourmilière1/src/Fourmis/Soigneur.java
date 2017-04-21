package Fourmis;

import Application.TestFourmiliere;
import Fourmilière.*;
import Message.*;

/**
 * 
 * @author Tochap
 *
 */
public class Soigneur extends Fourmi {
    /**
     * represente la cible d'un soigneur
     */
	private Fourmi fourmiCible;
	/**
	 * represente la vitesse d'un soigneur
	 */
	private int vitesse;
	/**
	 * represente le sens de deplacement d'un soigneur
	 */
	protected boolean sens = true;
    /**
     * Constructeur de la classe Soigneur
     * @param cycleVie initialise le cycle de vie d'un soigneur
     * @param vitesse initialise la vitesse d'un soigneur
     */
	public Soigneur(int cycleVie, int vitesse) {
		super(cycleVie);
		this.setVitesse(vitesse);
	}
	
    /**
     * Methode permettant d'acc&eacute;der &agrave; la valeur de la fourmi cible &agrave; un soigneur
     * @return retourne la valeur de la fourmi cible &agrave; un soigneur
     */
	public Fourmi getFourmiCible() {
		return fourmiCible;
	}
    /**
     * Methode permettant de modifier la valeur de la fourmi cible &agrave; un soigneur 
     * @param fourmiCible cycleVie represente la valeur &agrave; donner &agrave; la fourmi cible &agrave; un soigneur
     */
	public void setFourmiCible(Fourmi fourmiCible) {
		this.fourmiCible = fourmiCible;
	}
	/**
	 * methode permettant d'obtenir la valeur de la vitesse d'un soigneur
	 * @return retourne la valeur de la vitesse d'un soigneur
	 */
	public int getVitesse() {
		return vitesse;
	}
	/**
     * Methode permettant de modifier la valeur de la vitesse d'un soigneur
     * par la valeur entr&eacute;e en param&egrave;tre
     * @param vitesse represente la valeur &agrave; donner &agrave; la vitesse d'un soigneur
     */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	/**
	 * methode permettant d'obtenir la valeur du sens de deplacement d'un soigneur
	 * @return retourne la valeur du sens de deplacement d'un soigneur
	 */
	public boolean isSens() {
		return sens;
	}
	/**
     * Methode permettant de modifier la valeur au sens de deplacement d'un soigneur
     * par la valeur entr&eacute;e en param&egrave;tre
     * @param sens represente la valeur &agrave; donner au sens de deplacement d'un soigneur
     */
	public void setSens(boolean sens) {
		this.sens = sens;
	}
    @Override
	public void comportement(Fourmiliere f) {
		
		
			if (etat() == Etat.LIBRE) {
				Fourmi cible = f.fourmiBlessee();
				//s'il existe une fourmi bléssée
				if (cible !=null) {
				  //choix d'une fourmi blessée comme cible à un soigneur
				  fourmiCible = cible;
				  //On teste si le soigneur peut atteindre sa cible avant de l'envoyer
				  if (verifier(this, fourmiCible) == true) {
				    //on retire la fourmi choisi du tableau de fourmi bléssée provisoire
				    f.getFourmisRecup().add(fourmiCible);
				    f.getFourmisBlessees().remove(fourmiCible);
                    //la fourmi fait un pas
		     	    avancer();
				  }
					 
		        }//fin if
			}
			    //si OCCUPEE
			else
				if (etat() == Etat.OCCUPEE)
				   avancer();
				
		   // }//fin else
		
	}
	
	private void avancer() {
		//si le sens du soigneur est positif
		if (sens == true) {
			//il va vers sa cible
			setPosition(getPosition()+vitesse);
			System.out.print(afficheInfoFourmi()+" avance vers "+fourmiCible.afficheInfoFourmi()+" :Blesseé");
			TestFourmiliere.affiche(" située à "+fourmiCible.getPosition()+" Cycle de la fourmilière");//si elle depasse ou atteint son objectif
			//si le soigneur est arrivé à sa cible
			if (position == fourmiCible.position) {
			   TestFourmiliere.affiche(afficheInfoFourmi()+" est arrivé à sa cible");
			   setSens(false);
				
			}//fin if
		}
		//si son sens est negatif
		else {
			//il va vers la fourmilière
			setPosition(getPosition()-vitesse);
		    System.out.print(afficheInfoFourmi()+" avance vers la fourmilière ");
		    TestFourmiliere.affiche("Rapatriant "+fourmiCible.afficheInfoFourmi()) ;
		    if (position ==0) {
				
				setSens(true);
				Message msg = new RecuperationOk(this);
				msg.Notification();
				Messagerie.getInstance().addMessage(msg);
			}
		}
	}
	/**
	 * Methode permettant de comparer la position du soigneur par rapport &agrave; la position de sa cible
	 * si celle-ci n'est pas morte &agrave; la fourmili&egrave;re
	 * @param f1 represente un soigneur
	 * @param f2 represente la cible du soigneur
	 * @return retourne true si la condition est vrai et false elle est fausse
	 */
	private boolean verifier(Fourmi f1, Fourmi f2) {
		boolean bool = false;  
	   	
		   if (f1.getCycleVie() >= 2*f2.getPosition())
			  bool = true;
		   else
			   TestFourmiliere.affiche(f1.afficheInfoFourmi()+" je ne pourrai pas atteindre ma cible "+f2.afficheInfoFourmi());
		
	    return bool;
		
	}
	
}
