package vue.composant;

import javax.swing.JTextField;

public class MonInput extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonInput() {
		setOpaque(true);
		setEditable(false);
	}
	
	public MonInput(String text) {
		super(text);
	}

	
}
