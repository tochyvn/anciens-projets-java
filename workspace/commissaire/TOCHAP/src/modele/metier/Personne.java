package modele.metier;
/**
 * Classe Personne
 * @author TOCHAP 
 * @version v1.0
 */
public class Personne {
	private String name;
	private int position;
	/**
	 * Constructeur de la classe personne
	 * @param name nom de la personne
	 */
	public Personne(String name) {
		this.name = name;
		position = 0;
	}
	/**
	 * Methode permettant à la personne d'avancer
	 */
	public void avancer() {
		position++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	

}

