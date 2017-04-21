package vue.composant;

import javax.swing.JToolBar;

import vue.ecouteurs.AnalyseListener;
import vue.ecouteurs.CompileListener;
import vue.ecouteurs.OpenFileListener;
import vue.ecouteurs.SaveAsListener;
import vue.ecouteurs.SaveListener;

public class MonToolbar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonButton ouvrirButton;
	private MonButton saveButton;
	private MonButton saveAsButton;
	private MonButton compileButton;
	private MonButton analyseButton;
	private MonButton newButton;
	private MonButton fermerButton;

	public MonToolbar(OpenFileListener ouvrirListener, SaveListener saveListener, SaveAsListener saveAsListener, CompileListener compileListener, AnalyseListener analyseListener) {
		super();
		ouvrirButton = new MonButton("ouvrir");
		saveButton = new MonButton("save");
		saveAsButton = new MonButton("saveAs");
		compileButton = new MonButton("compile");
		analyseButton = new MonButton("analyse");
		newButton = new MonButton("new");
		fermerButton = new MonButton("fermer");
		ouvrirButton.addActionListener(ouvrirListener);
		saveButton.addActionListener(saveListener);
		saveAsButton.addActionListener(saveAsListener);
		compileButton.addActionListener(compileListener);
		analyseButton.addActionListener(analyseListener);
		add(ouvrirButton);
		add(saveButton);
		add(saveAsButton);
		add(compileButton);
		add(analyseButton);
		add(newButton);
		add(fermerButton);
	}


}
