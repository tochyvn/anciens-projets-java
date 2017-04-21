package vue.application;

import vue.composant.FenetrePrincipale;

public class Application {

	public Application() {
		
	}

	public static void main(String[] args) {
		FenetrePrincipale fenetre = null;
		fenetre = new FenetrePrincipale();
		fenetre.setVisible(true);
	}

}
