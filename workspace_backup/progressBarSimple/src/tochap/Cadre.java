package tochap;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Cadre extends JFrame {
	Panneau pan;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cadre() throws HeadlessException {
		super("TESTAWT");
		this.setVisible(true);
		this.setSize(800, 600);
		this.setLocation(100, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pan = new Panneau();
		getContentPane().add(pan);
		pan.testerProgress();
	}

}
