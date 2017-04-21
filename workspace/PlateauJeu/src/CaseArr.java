/**
 * 
 * @author silnti
 *
 */
public class CaseArr extends Case{
	/**
	 * Constructeur de la class CaseArr derivant de la classe Case
	 * @param nom represente le nom de la case
	 */
	public CaseArr(String nom) {
		super(nom);
			}
    /**
     * Cette methode est la redefinition de la methode effet() de la classe Case
     * cette case est la case d'arrivée
     */
	public void effet(Joueur joueur){
		
		joueur.setPosition(9);
		
		
		}

}
