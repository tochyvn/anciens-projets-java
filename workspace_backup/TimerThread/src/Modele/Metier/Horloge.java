package Modele.Metier;
/**
 * Classe Horloge
 * @author TOCHYVN
 *
 */
public abstract class Horloge {
	/**
	 * Represente le temps courant (à un instant quelconque)
	 */
	private int time;
	/**
	 * Represente le temps a egrener par l'horloge
	 */
	private int timeMax;
	/**
	 * Constructeur de la classe Horloge
	 * @param time represente la valeur initiale du temps de l'horloge
	 * @param timeMax represente le temps a egrener (fixé à l'instanciation)
	 */
	public Horloge(int time, int timeMax) {
		this.time = time;
		this.timeMax = timeMax;
	}
	/**
	 * Methode permettant d'avancer de +1 si on a un chrono et de -1 si on a un rebours
	 */
	public abstract void avancer();	
	/**
	 * Methode permettant de savoir si l'horloge a fini d'egrener le temps qui etait imparti
	 * @return retourne true si l'horloge a egrené tout le temps fixé, sinon retourne false
	 */
	public abstract boolean estArrivee();
	
	public abstract boolean isChrono();

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTimeMax() {
		return timeMax;
	}

	public void setTimeMax(int timeMax) {
		this.timeMax = timeMax;
	}

}
