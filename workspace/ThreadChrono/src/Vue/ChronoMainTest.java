package Vue;

import javax.swing.JLabel;

import Controleur.ChronoManager;

public class ChronoMainTest implements Affichage {

	public ChronoMainTest() {
		
	}

	@Override
	public void affiche(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		
		ChronoMainTest chronoTest = new ChronoMainTest();
		chronoTest.go();

	}
	
	public void go() {
		ChronoManager.getInstance().setVue(this);
		ChronoManager.getInstance().go();
	}

	@Override
	public void affiche(JLabel jl, String s) {
		// TODO Auto-generated method stub
		
	}

}
