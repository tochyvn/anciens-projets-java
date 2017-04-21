
public class CaseDep extends Case{	
	
	/**
	 * Constructeur de la class CaseDep derivant de la classe Case
	 * @param nom represente le nom de la case
	 */
	public CaseDep(String nom) {
		super(nom);
			}
	/**
     * Cette methode est la redefinition de la methode effet() de la classe Case
     * cette case ne possède pas d'effet, sauf quelle represente la case depart
     * elle est la position initiale de tout joueur
     */
	public void effet(Joueur player){
		
		player.setPosition(0);
		//System.out.println("Après effet vous serez à la case "+player.getPosition());
		
	}


}