package vue.ecouteurs;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JViewport;

import vue.composant.MonEditor;
import vue.composant.MonScrollPane;
import vue.composant.MonTabbedPane;
import controleur.Manager;

public class CompileListener implements ActionListener {
	private MonTabbedPane tab;
	//private MonEditor sortieError;
	
	public CompileListener(MonTabbedPane tab) {
		this.tab = tab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Compilation en cours...");
		Component comp = (MonScrollPane)tab.getSelectedComponent();
		int index = tab.indexOfComponent(comp);
		System.out.println("Voici l'index "+index);
		//Recuperation de la zone de saisie
		
		if (index != -1) {
			Manager.getInstance().compile(index);
			//sortieError.setText(sortieError.getText());
			//Manager.getInstance().getErrors();
		}

	}

}
