package Vue;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

import Model.Technique.Courreur;

public class MaBarProgression extends JProgressBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int min = 0;

	public MaBarProgression(Color c) {
		super(min, Courreur.ARRIVEE);
		setOpaque(true);
		setStringPainted(true);
		setPreferredSize(new Dimension(100,30));
		//setString(s);
		setBackground(c);
	}

}
