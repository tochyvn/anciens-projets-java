/**
 * 
 * @author silnti
 *
 */
public class CaseRecul extends Case{
	/**
	 * Constructeur de la class CaseRecul derivant de la classe Case
	 * @param nom represente le nom de la case
	 */
	public CaseRecul(String nom) {
		super(nom);
			}
	/**
     * Cette methode est la redefinition de la methode effet() de la classe Case
     * elle fait reculer un joueur d'une case
     */
	public void effet(Joueur player){
		
		System.out.println("Vous etes a la case "+player.getPosition()+" de Recul\n");

		int i = player.getPosition();
		player.setPosition(i-1);
		
		
	}

}

