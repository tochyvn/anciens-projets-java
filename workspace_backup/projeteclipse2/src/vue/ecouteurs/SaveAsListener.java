package vue.ecouteurs;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JViewport;

import controleur.Manager;
import vue.composant.MonEditor;
import vue.composant.MonScrollPane;
import vue.composant.MonTabbedPane;

public class SaveAsListener implements ActionListener {
	private MonTabbedPane tab;
	private MonEditor editeur;

	public SaveAsListener(MonTabbedPane tab, MonEditor editeur) {
		this.tab = tab;
		this.editeur = editeur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Bien entré dans l'action");
		Component comp = (MonScrollPane)tab.getSelectedComponent();
		int index = tab.indexOfComponent(comp);
		System.out.println("Voici l'index "+index);
		//Recuperation de la zone de saisie

		if (index != -1) {
			JViewport view = ((JScrollPane) comp).getViewport();
			editeur = (MonEditor) view.getView();
			String text = editeur.getText();
			System.out.println("Voici le contenu recuperer "+text);
			Manager.getInstance().saveAs(index, text);
		}
	}

}
