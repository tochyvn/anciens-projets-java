package Vue;

import Controleur.Manager;

public class CourseG implements AffichageG {

	private Fenetre f1;
	
	public CourseG() {
		f1 = new Fenetre();
	}

	public static void main(String[] args) {
		CourseG c = null;
		c = new CourseG();
		c.go();
	}
	

	
	private void go() {
		Manager.getInstance().setVueG(this);
		Manager.getInstance().go();
	}

	@Override
	public void afficheProgress(int i, int position, String name) {
		MaBarProgression[] tabBars = f1.getC1().getMesBars();
		tabBars[i].setValue(position);
		tabBars[i].setString(name);
	}

	@Override
	public void affiche(int i, String s) {
		MaBarProgression[] tabBars = f1.getC1().getMesBars();
		tabBars[i].setString(tabBars[i].getString()+" A FINI A "+s);
	}

}
