package Vue;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JApplet;
import javax.swing.JLabel;

import Controleur.ChronoManager;

public class ChronoApplet extends JApplet implements Affichage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel label1,label2;

	public ChronoApplet() throws HeadlessException {
		
		label1 = new JLabel("CHRONO");
		label2 = new JLabel("COMPTEAREBOURS");
		
		
	}

	@Override
	public void init() {
		getContentPane().setLayout(new FlowLayout());
		getContentPane().setBackground(Color.BLUE);
		getContentPane().add(label1);
		getContentPane().add(label2);
		go();
	}

	@Override
	public void affiche(JLabel jl, String s) { 
		jl.setText(jl.getText()+": "+s);
				
	}
	
	public void go() {
		
		ChronoManager.getInstance().setVue(this);
		ChronoManager.getInstance().go();
		
	}

	@Override
	public void affiche(String s) {
		// TODO Auto-generated method stub
		
	}

		

}
