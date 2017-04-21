package Fourmilière;

/**
 * 
 * @author silnti
 *
 */
public class Site {
	/**
	 * represente le nom d'un site
	 */
	private String nomSite;
	/**
	 * represente la position d'un site par rapport &agrave; la fourmiliere
	 */
	private int positionSite;
	/**
	 * represente la quantite de nourriture disponible a un site
	 */
	private int quantiteNour;
	/**
	 * represente le type de nourriture
	 */
	private String typeNour = "sucre";
	public boolean fin;
	/**
	 * Constructeur de la classe Site
	 * @param nomSite initialise le nom d'un site
	 * @param positionSite initialise la position d'un site
	 * @param quantitNour initialise la quantit&eacute; de nourriture &agrave; un site
	 */
	public Site(String nomSite, int positionSite, int quantitNour) {
		super();
		setNomSite(nomSite);
		setPositionSite(positionSite);
		setQuantiteNour(quantitNour);
		fin = false;
	}
    /**
     * Methode permettant &agrave; la valeur du nom d'un site
     * @return retourne la valeur du nom d'un site
     */
	public String getNomSite() {
		return nomSite;
	}
    
	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}
    /**
     * Methode permettant d'acceder &agrave; la valeur de la position d'un site
     * @return retourne la position d'un site par rapport &agrave; la fourmili&egrave;re
     */
	public int getPositionSite() {
		return positionSite;
	}
    
	public void setPositionSite(int positionSite) {
		this.positionSite = positionSite;
	}
    /**
     * Methode permettant d'acceder &agrave; la quantit&eacute; de nourriture disponible &agrave; un site
     * @return retourne la quantit&eacute; de nourriture disponible &agrave; un site
     */
	public int getQuantiteNour() {
		return quantiteNour;
	}
    /**
     * Methode permettant de modifier la quantit&eacute; de nourriture disponible &agrave; un site
     * @param quantiteNour represente la valeur &agrave; donner &agrave; la quantit&eacute; de nourriture &agrave; un site
     */
	public void setQuantiteNour(int quantiteNour) {
		this.quantiteNour = quantiteNour;
	}
	public String getTypeNour() {
		return typeNour;
	}
	public void setTypeNour(String typeNour) {
		this.typeNour = typeNour;
	}
	/**
	 * methode permettant de tester si un site de nourriture est vide
	 * @return retourne true si la qunatit&eacute; est egale &agrave; 0 sinon retourne false
	 */
	public boolean stockEstVide() {
		boolean flag = false;
		if (quantiteNour == 0)
			flag = true;
		return flag;	
	}
	/**
	 * methode permettant d'afficher les information sur un site (nomSite+stock+quantit&eacute;)
	 * @return retourne une chaine de caract&egrave;re
	 */
	public String afficherSite() {
		
		return nomSite+" && Stock = "+quantiteNour;
	}

}
