package vue.composant;

import javax.swing.JFileChooser;

public class MonFileChooser extends JFileChooser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonFileChooser() {
		super("/Users/silnti/TESTCOMPILE/");
	}

	public MonFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);	
	}

	

}
