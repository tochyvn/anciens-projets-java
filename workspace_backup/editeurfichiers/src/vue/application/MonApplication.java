package vue.application;

import vue.composant.MaFenetre;

public class MonApplication {
	
	private MaFenetre maFenPrinc;
	
	public MonApplication() {
		maFenPrinc = new MaFenetre();
	}

	public static void main(String[] args) {
		MonApplication launch = new MonApplication();
	}

}
