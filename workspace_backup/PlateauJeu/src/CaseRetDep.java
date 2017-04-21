/**
 * 
 * @author silnti
 *
 */
public class CaseRetDep extends Case{
	/**
	 * Constructeur de la classe CaseRetDep derivant de la classe Case
	 * @param nom represente le nom de la case
	 */
	public CaseRetDep(String nom) {
		super(nom);
			}
	
	/**
     * Cette methode est la redefinition de la methode effet() de la classe Case
     * elle fait un joueur retourner à la case Depart
     */
	
	public void effet(Joueur player){
		
		System.out.println("Vous etes sur la case RetourDepart numero "+player.getPosition());
		player.setPosition(0);
		//System.out.println("Après effet vous serez à la case "+player.getPosition());
	}

}
