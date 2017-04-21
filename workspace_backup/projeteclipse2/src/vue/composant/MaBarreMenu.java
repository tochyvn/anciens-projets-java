package vue.composant;

import javax.swing.JMenuBar;

import vue.ecouteurs.AnalyseListener;
import vue.ecouteurs.CompileListener;
import vue.ecouteurs.OpenFileListener;
import vue.ecouteurs.SaveAsListener;
import vue.ecouteurs.SaveListener;

public class MaBarreMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonMenu fichier;
	
	
	public MaBarreMenu(OpenFileListener ouvrirList, SaveListener saveListener, SaveAsListener saveAsListener, CompileListener compileListener, AnalyseListener analyseListener) {
		super();
		fichier = new MonMenu(ouvrirList, saveListener, saveAsListener, compileListener, analyseListener);
		this.add(fichier);
	}

}
