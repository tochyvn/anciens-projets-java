package Message;

import Application.TestFourmiliere;
import Fourmilière.Fourmiliere;
import Fourmis.Fourmi;

public class DepotNourriture extends Message{
    /*
     * Constructeur de la classe DepotNourriture
     */
	public DepotNourriture(Fourmi expediteur) {
		super(expediteur);
		this.notification = TypeMessage.DEPOT_DE_NOURRITURE;
	}
    /**
     * Methode permettant &agrave; une fourmi de notifier qu'elle à deposer de la nourriture à la fourmili&egrave;re
     */
	public void action(Fourmiliere f) {
		
		afficherTraitement();
		f.setQteStockee(f.getQteStockee()+1);
		TestFourmiliere.affiche("La quantité de nourriture dans la fourmilière est de : "+f.getQteStockee()+"\n");
	
	}
}
