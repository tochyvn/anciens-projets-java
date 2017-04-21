package Vue;

public interface Affichage {
	/**
	 * Methode permettant l'affichage des horloges dans la console
	 * @param s represente le temps courant de l'horloge
	 */
	void affiche(String s);
	/**
	 * Methode permettant l'affichage du chrono dans l'applet
	 * @param time represente le temps courant du chrono
	 */
	void afficheChr(String s);
	/**
	 * Methode permettant l'affichage du rebours dans l'applet
	 * @param time represente le temps courant du rebours
	 */
	void afficheReb(String s);

}
