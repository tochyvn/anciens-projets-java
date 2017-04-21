package vue.composant;

import java.util.ArrayList;

import javax.swing.JMenu;

public class MonMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MonMenuItem> mesItems;

	public MonMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public MonMenu(String s) {
		super(s);
		mesItems = new ArrayList<MonMenuItem>();
		this.addItems();
	}
	
	private void addItems() {
		mesItems.add(new MonMenuItem("Ouvrir"));
		mesItems.add(new MonMenuItem("Enregistrer"));
		mesItems.add(new MonMenuItem("Quitter"));
	}

}
