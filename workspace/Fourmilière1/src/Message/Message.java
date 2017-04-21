package Message;


import Application.TestFourmiliere;
import Fourmilière.Fourmiliere;
import Fourmis.*;
/**
 * 
 * @author tochap
 *
 */
public abstract class Message {
	/**
	 * represente l'expediteur d'un message
	 */
	protected Fourmi expediteur;
	/**
	 * represente une enumeration de type de message que peut d&eacute;poser une fourmi dans la messagerie
	 */
	protected TypeMessage notification;
	/**
	 * Constructeur de la classe Message
	 * @param expediteur initialise l'expediteur du message
	 */
	public Message(Fourmi expediteur) {
		super();
		this.expediteur = expediteur;
		
	}
	/**
	 * Methode permettant d'avoir accès &agrave; la valeur de l'expediteur  
	 * @return retourne la fourmi qui a envoy&eacute; le message
	 */
	public Fourmi getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Fourmi expediteur) {
		this.expediteur = expediteur;
	}

	public TypeMessage getNotification() {
		return notification;
	}

	public void setNotification(TypeMessage notification) {
		this.notification = notification;
	}
	/**
	 * Methode permettant de notifier lorsqu'un message est trait&eacute;
	 */
	public void afficherTraitement() {
		TestFourmiliere.affiche(expediteur.afficheInfoFourmi()+" a déposé un message "+notification);
	}
	/**
	 * methode permettant de notifier à l'&eacute;cran lorsqu'un message est depos&eacute;
	 */
	public void Notification() {
		TestFourmiliere.affiche(expediteur.afficheInfoFourmi()+" a envoyé un message "+notification);
	}
    /**
     * Methode abstraite qui represente le traitement effectu&eacute; par chaque type de message
     * @param f la fourmili&egrave;re
     */
	public abstract void action(Fourmiliere f);
	
	
}
