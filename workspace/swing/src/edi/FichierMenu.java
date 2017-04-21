package edi;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FichierMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem ouvrir;
	public FichierMenu(OuvrirListener ol) {
		super("Fichier");
		ouvrir = new JMenuItem("ouvrir classe java");
		ouvrir.addActionListener(ol);
		add(ouvrir);
	}

}
