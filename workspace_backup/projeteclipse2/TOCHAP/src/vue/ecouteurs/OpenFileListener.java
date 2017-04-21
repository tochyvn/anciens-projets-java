package vue.ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controleur.Manager;
import vue.composant.MonEditor;
import vue.composant.MonScrollPane;
import vue.composant.MonTabbedPane;

public class OpenFileListener implements ActionListener {

	private MonTabbedPane tab;
	private MonEditor sortieError;
	
	public OpenFileListener(MonTabbedPane tab, MonEditor editeurStandard, MonEditor sortieError) {
		this.tab=tab;
		this.sortieError=sortieError;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
			String[] contenu = Manager.getInstance().openFile();
			if (contenu[0] != null) {
				MonEditor editeur = new MonEditor();
				editeur.setText(contenu[1]);
				this.tab.setFocusable(true);
				this.tab.addTab(contenu[0], new MonScrollPane(editeur));
				sortieError.setText("Ouverture reussie");
			}
			else {
				sortieError.setText("Echec d'ouverture du fichier");
			}
	}
	
}
