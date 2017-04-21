package Modele.Technique;

import java.util.Timer;
import java.util.TimerTask;
/**
 * Classe MonTimer
 * @author TOCHYVN
 *
 */
public class MonTimer {
	private Timer timer;
	private TimerTask bombe;
	public static final int SECOND=10000;
	/**
	 * Constructeur de la classe MonTimer
	 */
	public MonTimer() {
		bombe = null;
		timer = new Timer();
	}
	/**
	 * Methode permettant de creer une exception dans le thread après 10 secondes
	 */
	public void programStop() {
			timer.schedule(bombe, SECOND);
	}
	/**
	 * Methode permettant d'associer une bombe au timer
	 * @param bombe represente la bombe à associer
	 */
	public void setBombe(TimerTask bombe) {
		if (bombe != null)
			this.bombe = bombe;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	

}
