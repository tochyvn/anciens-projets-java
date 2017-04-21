package vue.ecouteurs;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CloseListener extends WindowAdapter{

	public CloseListener() {
		super();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		String[] closeOptions = {"Oui","Non",};
		int resultat = 0;
		resultat = JOptionPane.showOptionDialog(null, "Voulez vous quittez?", 
				"Quitter l'application", JOptionPane.YES_NO_OPTION, 
				JOptionPane. 
				QUESTION_MESSAGE, null, closeOptions, closeOptions[0]);	
		switch (resultat) {
		
		case JOptionPane.OK_OPTION:
			super.windowClosing(e);
			System.exit(JFrame.EXIT_ON_CLOSE);
		break;
		
		}
	}
	
	

}
