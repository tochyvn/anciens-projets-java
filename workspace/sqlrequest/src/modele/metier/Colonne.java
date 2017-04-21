package modele.metier;

/**
 * Classe representant le structure d'une colonne de table
 * @author TOCHAP
 *@version 1.0.1
 */
public class Colonne {
	/**
	 * represente nom de la colonne
	 */
	private String name;
	/**
	 * Constructeur de la classe
	 * @param name represente nom de la colonne a sa creation
	 */
	public Colonne(String name) {
		this.setName(name);
	}
	/**
	 * Methode permettant de recuperer le nom d'une colonne
	 * @return represente le nom de la colonne retourné
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
