package vue.application;

import vue.composant.MaFenetre;

public class MonApplication {
	
	private MaFenetre window;

	public MonApplication() {
		window = new MaFenetre();
	}
	
	public static void main(String[] args) {
		MonApplication lancement = null;
		lancement = new MonApplication();
	}

}
