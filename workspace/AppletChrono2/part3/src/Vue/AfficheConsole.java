package Vue;

import Controleur.HorlogesManager;

public class AfficheConsole implements Affichage {

	public AfficheConsole() {
		
	}

	public static void main(String[] args) {
		AfficheConsole console = new AfficheConsole();
		console.go();
	}
	
	@Override
	public void affiche(String s) {
		System.out.print(s);
	}
	/**
	 * Methode permettant l'affichage en console et de lancer les Horloges
	 */
	public void go() {
		HorlogesManager.getInstance().setVue(this);
		HorlogesManager.getInstance().lancerHorloge();
	}

	@Override
	public void afficheChr(String s) {
		
		
	}

	@Override
	public void afficheReb(String s) {
		
		
	}

}
