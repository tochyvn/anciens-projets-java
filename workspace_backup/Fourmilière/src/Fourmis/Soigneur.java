package Fourmis;

/**
 * 
 * @author silnti
 *
 */
public class Soigneur extends FourmiMobile {
    /**
     * 
     * @param position
     * @param cycleVie
     * @param vitesse
     */
	public Soigneur(int position, int cycleVie, int vitesse) {
		super(position, cycleVie, vitesse);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Methode permettant de depla
	 */
	public void deplacer() {
		etat = Etat.OCCUPEE;
		incrementer();	
	}
	
	
	
}
