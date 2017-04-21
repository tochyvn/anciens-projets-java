package tochap;

import java.awt.Color;

import javax.swing.JProgressBar;

public class MonProgressBar extends JProgressBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonProgressBar() {
		
	}

	public MonProgressBar(int min, int max) {
		super(min, max);
		this.setOpaque(true);
		this.setBackground(Color.GREEN);
		this.setForeground(Color.BLUE);
		setValue(0);
		setStringPainted(true);
		setSize(300, 100);
		setString("TOCHAP");
	}

}
