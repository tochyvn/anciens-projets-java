package Fourmis;

import Application.TestFourmiliere;
import Fourmilière.*;
import Message.*;



/**
 * 
 * @author Tochap
 *
 */
public class Ouvriere extends Fourmi {
	/**
	 * repr&eacute;sente le site de destination d'une ouvri&egrave;re
	 */
    private Site siteCible;
    /**
     * repr&eacute;sente la vitesse d'une ouvri&egrave;re
     */
	private int vitesse;
	/**
	 * represente le sens de deplacement d'une ouvri&egrave;re
	 */
	protected boolean sens = true;
	/**
	 * Constructeur de la classe Ouvri&egrave;re
	 * @param cycleVie initialise le cycle de vie d'une ouvri&egrave;re
	 * @param vitesse initialise la vitesse d'une ouvri&egrave;re 
	 */
	public Ouvriere(int cycleVie, int vitesse) {
		super(cycleVie);
		this.vitesse = vitesse;
	}
	/**
	 * methode permettant d'obtenir la valeur de la vitesse d'une ouvri&egrave;re
	 * @return retourne la valeur de la vitesse d'une ouvri&egrave;re
	 */
	public int getVitesse() {
		return vitesse;
	}
	/**
     * Methode permettant de modifier la valeur de la vitesse d'une ouvri&egrave;re
     * par la valeur entr&eacute;e en param&egrave;tre
     * @param vitesse represente la valeur &agrave; donner &agrave; la vitesse d'une ouvri&egrave;re
     */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	/**
	 * Methode permettant d'acceder &agrave; la valeur du site de destination &agrave; une ouvri&egrave;re
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
	 * Methode permettant &agrave; l'ouvri&egrave;re de faire un pas dans n'importe quel sens
	 * soit vers la fourmili&egrave;re, soit vers un site
	 */
	private void avancer() {
		//si son sens est positif 
		if (sens == true) {
			TestFourmiliere.affiche(afficheInfoFourmi()+" avance vers le site ("+siteCible.afficherSite()+")");
			setPosition(position+vitesse);
			//si l'ouvrière atteint sa cible 
			if (position == siteCible.getPositionSite()) {
			    //Si le stock de nourriture est épuisé
				if (siteCible.stockEstVide()) {
				    //la fourmi ajoute un message dans la boite à message
		        	Message msg = new FinNourriture(this);
		        	FinNourriture fin=(FinNourriture)msg;
		        	
		        	fin.siteVide = siteCible;
		            Messagerie.getInstance().addMessage(fin);
		        	msg.Notification();
		        	
				}//fin if
		         //sinon
		        else  {
		        	TestFourmiliere.affiche(afficheInfoFourmi()+" prend de la nourriture au site ("+siteCible.afficherSite()+")");
		        	siteCible.setQuantiteNour(siteCible.getQuantiteNour() - 1);
		        	TestFourmiliere.affiche("La quantité restante ("+siteCible.afficherSite()+")\n");
		         }//fin else
				setSens(false);
			}
		}
		//sinon
		else {
			TestFourmiliere.affiche(afficheInfoFourmi()+" avance vers la fourmilière");
			setPosition(position-vitesse);
			//si la fourmi arrive à la fourmilière
			if(position == 0) {
				Message msg = new DepotNourriture(this);
	            Messagerie.getInstance().addMessage(msg);
	            msg.Notification();
			    //elle change son sens de deplacement
				setSens(true);	
	           
			   }//fin if  
			
		}
	}
	@Override
	public void comportement(Fourmiliere f) {
			
			if (etat() == Etat.LIBRE) {
				  siteCible = f.genererSiteAleatoire();
				  if (siteCible != null) {
			         sens = true;
		     	     avancer();
			      }
					 
			}
		
			else 
			   if (etat() == Etat.OCCUPEE)
				  avancer();
	}
	
}//Fin 
