package Fourmilière;

/**
 * 
 * @author silnti
 *
 */
public class Site {
	
	private String nomSite;
	private int positionSite;
	private int quantiteNour;
	private String typeNour;
	/**
	 * Constructeur de la classe site
	 * @param nomSite nom d'un site de nourriture
	 * @param position position d'un site par rapport à la fourmilière
	 * @param quantite quantite de nourriture disponible sur un site
	 * @param typeNour type de nourriture
	 */
	public Site(String nomSite, int position, int quantite, String typeNour) {
	    this.nomSite = nomSite;
		this.setPositionSite(position);
		this.setQuantiteNour(quantite);
		this.setTypeNour(typeNour);
	
	}
	/**
	 * Methode permettant l'ajout d'un nouveau site de nourriture
	 * @param site
	 * @return
	 */
    public void addSite(Site site) {
		
    	
		
	}
    /**
     * Methode permettant d'acceder au nom d'un site
     * @return le nom d'un site
     */
	public String getNomSite() {
		return nomSite;
	}
    
	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}
    /**
     * Methode permettant d'acceder à la valeur de la position d'un site
     * @return
     */
	public int getPositionSite() {
		return positionSite;
	}
    
	public void setPositionSite(int positionSite) {
		this.positionSite = positionSite;
	}
    
	public int getQuantiteNour() {
		return quantiteNour;
	}
    
	public void setQuantiteNour(int quantiteNour) {
		this.quantiteNour = quantiteNour;
	}

	public String getTypeNour() {
		return typeNour;
	}

	public void setTypeNour(String typeNour) {
		this.typeNour = typeNour;
	}
	

}
