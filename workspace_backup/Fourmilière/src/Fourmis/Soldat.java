package Fourmis;

/**
 * 
 * @author silnti
 *
 */
public class Soldat extends FourmiMobile {
	
	
	/**
	 * Constructeur d'un objet de type Soldat
	 * @param position
	 * @param cycleVie
	 * @param vitesse
	 */
    public Soldat(int position, int cycleVie, int vitesse) {
		super(position, cycleVie, vitesse);
	
	}

	/**
     * Methode permettant de deplacer un soldat
     */
	public void deplacer() {
		this.etat = Etat.OCCUPEE;
		incrementer();
		
		
	}
	
}
