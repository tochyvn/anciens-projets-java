package prodcons.vue;

import prodcons.controleur.Manager;

public class Jeu implements Vue {

	public Jeu(String s) {
		Manager.getInstance().init(s);
	}

	@Override
	public void afficher(char c) {
	System.out.print(c);
	}

	public static void main(String[] args) {
		Jeu j = null;
		if(args.length <= 0)
		{
			System.out.println("veuillez entrer une phrase en argument");
			System.exit(1);
		}
		System.out.println(args[0]);
		j = new Jeu(args[0]);
		j.go();

	}

	private void go() {
		Manager.getInstance().setVue(this);
		Manager.getInstance().go();
	}

}
