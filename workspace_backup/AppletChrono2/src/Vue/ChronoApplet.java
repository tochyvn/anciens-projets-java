package Vue;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JApplet;
import javax.swing.JLabel;

import Controleur.HorlogesManager;

public class ChronoApplet extends JApplet implements Affichage {

	private static final long serialVersionUID = 1L;
	/**
	 * Attribut permettant l'affichage du Chrono
	 */
	private JLabel label1;
	/**
	 * Attribut permettant l'affichage du compte à rebours
	 */
	private JLabel label2;
	
	@Override
	public void init() {
		label1 = new JLabel("CHRONO : ");
		label2 = new JLabel("   COMPTE A REBOURS : ");
		label1.setOpaque(true);
		label1.setBackground(Color.BLUE);
		label1.setForeground(Color.WHITE);
		label2.setOpaque(true);
		label2.setBackground(Color.WHITE);
		label2.setForeground(Color.BLUE);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(label1);			
		this.getContentPane().add(label2);	
	}
	
	@Override
	public void start() {
		this.go();
	}


	@Override
	public void affiche(String s) {
		
	}
	/**
	 * Methode permettant l'affichage dans l'applet et le lancement des horloges
	 */
	private void go() {
		HorlogesManager.getInstance().setVue(this);
		HorlogesManager.getInstance().lancerHorloge();
	}
	
	@Override
	public void afficheChr(String s) {
		label1.setText("CHRONO : ");
		label1.setText(label1.getText()+s);	
	}

	@Override
	public void afficheReb(String s) {
		label2.setText("   COMPTE A REBOURS : ");
		label2.setText(label2.getText()+s);
	}
	
}
