package Modele.Metier;
/**
 * Classe Rebours derivant de la classe Horloge
 * @author TOCHYVN
 *
 */
public class Rebours extends Horloge {
	/**
	 * Constructeur de la classe Rebours
	 * @param timeMax represente le temps a egrener par le rebours
	 */
	public Rebours(int timeMax) {
		super(timeMax,timeMax);
	}

	@Override
	public void avancer() {
		//HorlogesManager.getInstance().afficheRebours(this.getTime()+"");
		this.setTime(getTime()-1);
	}

	@Override 
	public boolean estArrivee() {
		boolean bool=false;
		if (this.getTime()<0)
			bool=true;
		
		return bool;
	}

	@Override
	public boolean isChrono() {
	
		return false;
	}


}
