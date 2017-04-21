package edi;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FermetureListener extends WindowAdapter {

	public FermetureListener() {
		super();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Object[] lesTextes = {"oui","non","annuler"};
		int res = 0;
		System.out.println("SORTIE PROPRE ecouteur");
		res = JOptionPane.showOptionDialog(null, "on sort","SORTIE",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,
				lesTextes,lesTextes[1]);
		switch (res) {
		case JOptionPane.CANCEL_OPTION:
			System.out.println("annule");
			break;
		case JOptionPane.YES_OPTION:
			System.out.println("oui");
			break;
		case JOptionPane.NO_OPTION:
			System.out.println("non");
			break;
		default:
			System.out.println("perdu");
			break;
		}
		super.windowClosing(e);
		System.exit(JFrame.EXIT_ON_CLOSE);
	}
	

}
