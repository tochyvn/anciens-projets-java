package Message;


import Fourmilière.Fourmiliere;
import Fourmis.Fourmi;

public class Blessee extends Message{
	/*
	 * Constructeur de la classe Blessee
	 */
	public Blessee(Fourmi expediteur) {
		super(expediteur);
		this.notification = TypeMessage.BLESSEE;
	}
	
    /**
     * Methode permettant &agrave; une fourmi de notifier qu'elle est bless&eacute;e et de la supprimer 
     * du tableau de fourmi puis de l'ajouter dans le tableau de fourmi bless&eacute;e 
     */
	@Override 
	public void action(Fourmiliere f) {
		//affichage de la fourmi blessée
		afficherTraitement();
		//si la fourmi est morte hors de la fourmilière
		if (expediteur.getPosition() != 0) {
		  //ajouter l'expediteur du message dans le tableau de fourmis blessées
		  f.getFourmisBlessees().add(expediteur);
		  //extraire l'expediteur du message du tableau de fourmis vivante
		  f.getFourmis().remove(expediteur);
		}//fin if
		//sinon (morte dans la fourmilière)
		else {
			f.getFourmisMortes().add(expediteur);
			f.getFourmis().remove(expediteur);
			
		}
		
	}
	

}
