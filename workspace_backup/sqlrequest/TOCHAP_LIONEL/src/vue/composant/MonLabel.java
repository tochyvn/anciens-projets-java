package vue.composant;

import java.awt.Font;
import javax.swing.JLabel;

public class MonLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonLabel() {
		super();
	}

	public MonLabel(String text) {
		super(text);
		this.setFont(new Font("Arial bold", Font.BOLD, 14));
		//this.setPreferredSize(new Dimension(100, 100));
		//this.setMaximumSize(new Dimension(100, 100));
	}
	
	

}
