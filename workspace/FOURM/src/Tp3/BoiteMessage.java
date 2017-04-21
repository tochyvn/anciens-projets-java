package Tp3;

import java.util.ArrayList;

public class BoiteMessage {
	ArrayList<Message> tabMessage = new ArrayList<Message>();
    private static BoiteMessage instance = null;
	/**
	 * 
	 */
	private BoiteMessage() {
		
	}
	/**
	 * 
	 * @return
	 */
	public static BoiteMessage getInstance() {
		if (instance == null) {
			instance = new BoiteMessage();
		}
		return instance;
	}
	/**
	 * 
	 * @param msg
	 */
	public Message ajouterMessage(Message msg) {
		tabMessage.add(msg);
		return msg;
	}
	/**
	 * Methode permettant de lire le message, puis le supprimer et de passer au suivant
	 * @return
	 */
	public Message nextMessage() {
		
		Message message=tabMessage.get(0);
		tabMessage.remove(0);
		return message;
	}
	
	public boolean estVide() {
		boolean drap = false;
		if (tabMessage.isEmpty()) {
			drap = true;
		}
		return drap;
			
	}
	
}
