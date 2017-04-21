import java.util.ArrayList;

import javax.swing.JMenu;

import vue.composant.MonItem;


public class MonMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MonItem> mesItems;

	public MonMenu() {
		super();
	}

	public MonMenu(String s) {
		super(s);
		
	}

}
