package Fourmis;

/**
 * 
 * @author silnti
 *
 */
public abstract class Fourmi {
	
	protected int position;
	protected int cycleVie;
	
	/**
	 * Constructeur de la classe Fourmi
	 * @param position position d'une fourmi par rapport à la fourmilière
	 * @param cycleVie cycle de vie de la fourmi
	 */
	public Fourmi(int position, int cycleVie) {

		this.position = position;
		this.cycleVie = cycleVie;
		
	}

	/**
	 * methode permettant d'obtenir la position d'une fourmi
	 * @return retourne la position d'une fourmi
	 */
	public int getPosition() {
		return position;
	}
    /**
     * Methode permettant de modifier la position d'une fourmie
     * @param position represente la position du joueur
     */
	public void setPosition(int position) {
		this.position = position;
	}
    /**
     * 
     * @return
     */
	public int getCycleVie() {
		return cycleVie;
	}
    /**
     * 
     * @param cycleVie
     */
	public void setCycleVie(int cycleVie) {
		this.cycleVie = cycleVie;
	}
		
		
}
