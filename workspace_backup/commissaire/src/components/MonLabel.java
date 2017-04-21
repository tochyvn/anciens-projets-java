package components;

import java.awt.Color;
import javax.swing.JLabel;

public class MonLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonLabel() {
		super("A VOS MARQUES");
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setOpaque(true);
		setBackground(Color.BLUE);
	}


}
