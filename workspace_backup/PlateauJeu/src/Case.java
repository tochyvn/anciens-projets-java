/**
 * 
 * @author silnti
 *
 */
public abstract class Case {
	
	protected String nom;
	
	/**
	 * Constructeur avec paramètres de la classe Case
	 * @param nom symbolise le nom de la case
	 */
	public Case(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Cette methode permet d'accéder au nom de la case
	 * @return retourne le nom de la case
	 */
	public String getNom() {
		return nom;
	}
	
    /**
     * Cette methode permet de modifier le nom d'une case
     * @param nom represente le nom de la case à modifier
     */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * methode abstraite de la classe Joueur qui sera redefini dans les classes filles
	 * cette methode prend en paramètre un joueur
	 * @param joueur represente le joueur
	 */
	public abstract void effet (Joueur joueur);

	

}

