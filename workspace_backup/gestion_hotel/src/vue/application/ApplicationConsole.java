package vue.application;

import javax.swing.JFrame;

import controleur.Manager;

public class ApplicationConsole {

	public ApplicationConsole() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//Manager.getInstance().getConnexion();
		JFrame jf = new JFrame("testTOCH");
		jf.setBounds(100, 100, 100, 100);
		jf.setVisible(true);
	}

}