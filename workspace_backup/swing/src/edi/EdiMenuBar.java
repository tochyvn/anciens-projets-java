package edi;

import javax.swing.JMenuBar;

public class EdiMenuBar extends JMenuBar {
	private FichierMenu fm;
	public EdiMenuBar(OuvrirListener ol) {
	super();
	fm = new FichierMenu(ol);
	add(fm);
	}

}
