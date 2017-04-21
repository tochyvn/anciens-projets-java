package Message;

import java.util.ArrayList;
/**
 * 
 * @author tochap
 *
 */
public class Messagerie {
	/**
	 * represente une collection de message
	 */
	private ArrayList<Message> tabMessage;
	/**
	 * représente une instance de la messagerie
	 */
	private static Messagerie instance= null;
    /**
     * Constructeur priv&eacute;e de la classe Messagerie
     */
	private Messagerie() {
		tabMessage = new ArrayList<Message>();
	}
	/**
	 * Methode permettant de creer une instance de la boite &agrave; message si elle n'existe pas
	 * @return retourne une instance si elle null, sinon retourne l'instance deja cr&eacute;e
	 */
	public static Messagerie getInstance() {
		
		if (instance == null) 
			instance = new Messagerie();
		
	    return instance;
	    
	}
	/**
	 * Methode permettant d'ajouter un message dans la messagerie
	 * @param msg le message &agrave; ajouter dans la messagerie
	 */
	public void addMessage(Message msg) {	
		tabMessage.add(msg);
		//return msg;
	}
	/**
	 * Methode permettant de lire un message de la boite &agrave; message
	 * Elle recupère le message, le supprime, et enfin retourne se message 
	 * @return represente le message lu
	 */
	public Message readMessage() {
		Message msg = tabMessage.get(0);
		tabMessage.remove(0);
		return msg;
	}
	/**
	 * Methode permettant de savoir si la boite &agrave; message est vide
	 * @return retourne true si elle est vide et false si elle ne l'est pas 
	 */
	public boolean estVide() {
		boolean flag = false;
		if (tabMessage.isEmpty()) {
			flag = true;
		}
		return flag;
			
	}
	
}
