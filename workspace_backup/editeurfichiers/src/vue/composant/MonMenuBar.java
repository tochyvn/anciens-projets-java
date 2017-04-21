package vue.composant;

import java.util.ArrayList;

import javax.swing.JMenuBar;

public class MonMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MonMenu> mesItems;

	public MonMenuBar() {
		mesItems = new ArrayList<MonMenu>();
		this.addMenus();
	}
	
	private void addMenus() {
		mesItems.add(new MonMenu("File"));
		mesItems.add(new MonMenu("Traitement"));
	
	}

}
