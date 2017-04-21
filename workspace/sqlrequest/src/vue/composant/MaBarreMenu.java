package vue.composant;

import java.awt.Color;

import javax.swing.JMenuBar;

import vue.action.AuthentificationListener;
import vue.action.ExecuteListener;
import vue.action.ExporterListener;

public class MaBarreMenu extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonMenu menu;

	public MaBarreMenu(AuthentificationListener connexion, ExecuteListener execution, ExporterListener export) {
		menu = new MonMenu("Fichier", connexion, execution, export);
		this.add(menu);
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.BLACK);
		this.setOpaque(true);
	}

	public MonMenu getMenu() {
		return menu;
	}

}
