/**
 * 
 * @author silnti
 *
 */
public class CaseRien extends Case{
	
	/**
	 * Constructeur de la classe CaseRien derivant de la classe Case
	 * @param nom represente le nom de la case
	 */
	public CaseRien(String nom) {
		super(nom);
		}
	/**
     * Cette methode est la redefinition de la methode effet() de la classe Case
     * Cette methode n'a aucun effet
     */
	public void effet(Joueur player){
		
		
		//System.out.println("Donc vous laissez votre pion à cette case\n");
		
		player.getPosition();
		
		
	}
}
