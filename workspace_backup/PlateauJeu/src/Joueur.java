/**
 * 
 * @author silnti
 *
 */
public class Joueur {
	
    
	private String nom;
	private int position;
	
	/**
	 * Constructeur de la classe joueur
	 * @param nom represente le nom d'un joueur
	 */
	public Joueur(String nom){
		
		this.nom=nom;
		setPosition(0);
		
	}
	
	
	/**
	 * Cette methode permet de recuperer le nom du joueur
	 * @return retourne le nom d'un joueur
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Cette methode permet de modifier le nom d'un joueur
	 * @param nom represente le nom d'un joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Cette methode permet de recuperer la position d'un joueur
	 * @return retourne la position d'un joueur
	 */
	public int getPosition() {
		return position;
		
	
	}
	/**
	 * Cette methode permet de modifier la position d'un joueur
	 * @param position represente la position du joueur
	 */
	public void setPosition(int position) {
		this.position = position;
	}

}

