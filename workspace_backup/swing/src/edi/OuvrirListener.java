package edi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class OuvrirListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		File fic = null;
		JFileChooser jfc = new JFileChooser();
		int res = jfc.showOpenDialog(null);
		switch (res) {
		case JFileChooser.APPROVE_OPTION:
			fic = jfc.getSelectedFile();
			Manager.getInstance().ajouteModele(fic.getName());
			break;

		default:
			System.out.println("annule");
			break;
		}
		
		System.out.println("le manager m'a repondu:"+Manager.getInstance().getModele());

	}

}
