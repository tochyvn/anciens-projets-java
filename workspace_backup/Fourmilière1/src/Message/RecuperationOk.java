package Message;


import Fourmilière.Fourmiliere;
import Fourmis.Fourmi;
import Fourmis.Soigneur;

public class RecuperationOk extends Message{
	/**
	 * Constructeur de la classe RecuperationOK
	 * @param expediteur repr&eacute;sente l'expediteur du message
	 */
	public RecuperationOk(Fourmi expediteur) {
		super(expediteur);
		this.notification = TypeMessage.RECUPERATION_OK;
	}
    @Override
	public void action(Fourmiliere f) {
		
		afficherTraitement();
		//l'expediteur du message est un soigneur
		Soigneur exp = (Soigneur)expediteur;
		//on met la fourmi cible du soigneur dans le tableau de fourmi morte
		f.getFourmisMortes().add(exp.getFourmiCible());
		//on supprime la Fourmi cible du soigneur du tableau de fourmi en cours de recuperation
	    f.getFourmisRecup().remove(exp.getFourmiCible());
	    //la position de la cible est donc egale à 0
	    exp.getFourmiCible().setPosition(0);
	}

}
