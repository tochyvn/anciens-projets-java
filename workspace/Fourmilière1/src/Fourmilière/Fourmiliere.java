package Fourmilière;

import java.util.ArrayList;
import java.util.Scanner;

import Application.TestFourmiliere;
import Fourmis.*;
import Message.Blessee;
import Message.Message;
import Message.Messagerie;


/**
 * 
 * @author tochap
 *
 */
public class Fourmiliere {
	/**
	 * repr&eacutesente une collection de site
	 */
	private Site []sites = new Site[5]; 
	/**
	 * repr&eacutesente une collection de fourmi (ouvri&egrave;re, soldat, et soigneur)
	 */
	private ArrayList<Fourmi> fourmis = new ArrayList<Fourmi>();
	/**
	 * repr&eacutesente la dur&eacutee de vie de la fourmili&egrave;re
	 */
	private int dureeVie;
	/**
	 * repr&eacutesente la quantite en stock a la fourmili&eagrave;re
	 */
	private int qteStockee = 0;
	/**
	 * represente une collection de fourmis ayant signal&eacute;es bless&eacute;es
	 */
	private ArrayList<Fourmi> fourmisBlessees = new ArrayList<Fourmi>();
	/**
	 * repr&eacutesente une collection de fourmis bless&eacutees en cours de recuperation  
	 */
	private ArrayList<Fourmi> fourmisRecup = new ArrayList<Fourmi>();
	/**
	 * repr&eacutesente une collection de fourmis bless&eacutees final dans la fourmilière
	 */
	private ArrayList<Fourmi> fourmisMortes = new ArrayList<Fourmi>();
	Scanner sc = new Scanner(System.in);
	/**
	 * Constructeur de la classe fourmili&egrave;re 
	 */
	public Fourmiliere() {
		TestFourmiliere.affiche("\n***************************STIMULATION DE LA VIE D'UNE FOURMILIÈRE********************\n");
		TestFourmiliere.affiche("Entrer le nombre de cycle de la simulation: ");
		this.dureeVie = sc.nextInt();
		Fourmi reine = new Reine(dureeVie);
		initSite();
		//reine.comportement(this);	
		fourmis.add(reine);
	}
	/**
	 * Methode permettant d'acc&eacute;der &agrave; la dure&eacute; d'une ouvri&agrave;
	 * @return retournela duree de vie de la fourmiliere 
	 */
	public int getDureeVie() {
		return dureeVie;
	}
	/**
	 * Methode permettant l'acc&egrave;s au sites situ&eacute;s autour de la fourmili&egrave;re
	 * @return retourne un tableau de sites
	 */
    public Site[] getSites() { 
		return sites;
	}
	public void setSites(Site[] sites) {
		this.sites = sites;
	}
    /**
     * Methode permettant d'acceder &agrave; la collection de fourmi vivante dans la fourmili&egrave;re
     * @return retourne une collection de fourmis vivantes
     */
	public ArrayList<Fourmi> getFourmis() {
		return fourmis;
	}
	public void setFourmis(ArrayList<Fourmi> fourmis) {
		this.fourmis = fourmis;
	}
	/**
     * Methode permettant d'acceder &agrave; la collection de fourmi bl&eacute;ss&eacute; en dehors de la fourmili&egrave;re
     * @return retourne une collection de fourmis bless&eacute;es
     */
	public ArrayList<Fourmi> getFourmisBlessees() {
		return fourmisBlessees;
	}
	public void setFourmisBlessees(ArrayList<Fourmi> fourmisBlessees) {
		this.fourmisBlessees = fourmisBlessees;
	}
    /**
     * Methode permettant d'acceder &agrave; la quantit&eacute; de nourriture stock&eacute;e dans la fourmili&egrave;re
     * @return la quantit&eacute; de nourriture stock&eacute;e dans la fourmili&egrave;re
     */
	public int getQteStockee() {
		return qteStockee;
	}
	/**
	 * Methode permettant de modifier la quantit&eacute; de nourriture stock&eacute;e dans la fourmili&egrave;re
     * @param qteStockee represente la valeur &agrave; donner &agrave; la quantit&eacute; de nourriture stock&eacute;e dans la fourmili&egrave;re
	 */
	public void setQteStockee(int qteStockee) {
		this.qteStockee = qteStockee;
	}
	/**
     * Methode permettent l'initialisation des differents sites de nourriture
     */
	private void initSite() {
		TestFourmiliere.affiche("Entrer la quantité de nourriture dans chaque site: ");
		int qte = sc.nextInt();
		for (int i = 0; i<sites.length; i++)
			sites[i] = new Site("Site "+(i+1), i+1, qte);
	
	}
    /**
     * Methode generant un site aleatoire contenant de la nourriture parmis les 5 disponibles
     * @return retourne un site s'il n'est pas vide, sinon retourne null
     */
	public Site genererSiteAleatoire() {
	    Site a = null;
		int x = (int)((sites.length)*Math.random());
		if (!sites[x].stockEstVide()) {
			a = sites[x];
		}
			return a;
			
	}
	/**
	 * Methode permetant de renvoy&eacute; la premi&egrave;re fourmi du tableau de fourmis bless&eacute;es
	 * @return retourne une fourmi bl&eacute;ss&eacute;e ou un null 
	 */
	public Fourmi fourmiBlessee() {
		Fourmi blessee =null ;
		if (!fourmisBlessees.isEmpty()) 
		   blessee = fourmisBlessees.get(0);
		
		return blessee;
	   
	}
	/**
	 * Methode permettant de lancer un cycle
	 */
    public void nouveauCycle() {
        
        for(int i = 0; i<fourmis.size(); i++) {	 
   		   fourmis.get(i).comportement(this);
   		   //diminution de la vie des fourmis
   		   if(fourmis.get(i).getCycleVie() > 0) {
   		     fourmis.get(i).setCycleVie(fourmis.get(i).getCycleVie() - 1);
   		     
   		     if (fourmis.get(i).etat() == Etat.INACTIVE) {
   		    	Message msg = new Blessee(fourmis.get(i));
   				msg.Notification();
   				Messagerie.getInstance().addMessage(msg);
   			   
   		     }
   		   }
   	    }//fin du parcours de la collection de fourmis
         
     }//fin methode
    
	public ArrayList<Fourmi> getFourmisRecup() {
		return fourmisRecup;
	}
	public void setFourmisRecup(ArrayList<Fourmi> fourmisRecup) {
		this.fourmisRecup = fourmisRecup;
	}
	public ArrayList<Fourmi> getFourmisMortes() {
		return fourmisMortes;
	}
	public void setFourmisMortes(ArrayList<Fourmi> fourmisMortes) {
		this.fourmisMortes = fourmisMortes;
	}
	
    
         
}
	
	





	
	
	
	
	
    

