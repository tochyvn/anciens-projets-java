package Vue;

import Controleur.Manager;

public class Course implements Vue {
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void affiche(String c) {
		System.out.print(c);
	}
	
	public static void main(String[] args) {
		Course c = null;
		c = new Course();
		c.go();
	}
	
	private void go(){
		Manager.getInstance().setVue(this);
		Manager.getInstance().go();
	}

	

}
