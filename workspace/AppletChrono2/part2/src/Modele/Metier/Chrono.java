package Modele.Metier;

/**
 * Classe Chrono derivant de la classe Horloge
 * @author TOCHVYN
 *
 */
public class Chrono extends Horloge {
	/**
	 * Constructeur de la classe Chrono
	 * @param timeMax represente le temps a egrener par chrono
	 */
	public Chrono(int timeMax) {
		super(0,timeMax);
	}

	@Override
	public void avancer() {
		//HorlogesManager.getInstance().afficheChrono(this.getTime());
		setTime(getTime()+1);
	}

	@Override
	public boolean estArrivee() {
		boolean bool = false;
		if (this.getTime()<=getTimeMax())
			bool=false;
		else
			bool=true;
		
		return bool;
	}

	@Override
	public Boolean isChrono() {
		return true;
	}
	
	

}
