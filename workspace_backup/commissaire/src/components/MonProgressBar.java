package components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

import modele.technique.Courreur;

public class MonProgressBar extends JProgressBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonProgressBar(Color c, boolean flag, String nom) {
		setPreferredSize(new Dimension(500, 50));
		setStringPainted(true);
		if (flag) {
			setString(nom);
			setMinimum(0);
			setMaximum(Courreur.DEPART);
		}
		else {
			setMinimum(Courreur.DEPART);
			setMaximum(Courreur.ARRIVEE);
		}
		setForeground(c);
	}

}
