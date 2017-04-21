package Message;

import Application.TestFourmiliere;
import Fourmilière.Fourmiliere;
import Fourmilière.Site;
import Fourmis.Fourmi;
import Fourmis.Ouvriere;;

public class FinNourriture extends Message{
	
	//On aura une agregation entre la classe courante et la classe Site
	public Site siteVide;
	
	/**
	 * Constructeur de la classe FinNourriture
	 * @param expediteur represente la fourmi qui &agrave; envoy&eacute;e la message
	 */
	public FinNourriture(Fourmi expediteur) {
		super(expediteur);
		this.notification = TypeMessage.FIN_NOURRITURE;
		siteVide = null;
		
	}
    @Override
	public void action(Fourmiliere f) {
		afficherTraitement();
		Ouvriere ouv = (Ouvriere)expediteur;
	    //ouv.getSiteCible().setQuantiteNour(5);
        //TestFourmiliere.affiche("Regeneration de la nourriture au site "+"("+ouv.getSiteCible().afficherSite()+")");
    	siteVide.fin = true;
	}
	public Site getSiteVide() {
		return siteVide;
	}
	public void setSiteVide(Site siteVide) {
		this.siteVide = siteVide;
	}

}
