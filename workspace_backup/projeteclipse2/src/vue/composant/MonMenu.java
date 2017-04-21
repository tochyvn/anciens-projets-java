package vue.composant;

import javax.swing.JMenu;

import vue.ecouteurs.AnalyseListener;
import vue.ecouteurs.CompileListener;
import vue.ecouteurs.OpenFileListener;
import vue.ecouteurs.SaveAsListener;
import vue.ecouteurs.SaveListener;

public class MonMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonMenuItem itemOuvrir;
	private MonMenuItem itemSave;
	private MonMenuItem itemSaveAs;
	private MonMenuItem itemFermer;
	private MonMenuItem itemNew;
	private MonMenuItem itemCompile;
	private MonMenuItem itemAnalyse;
	
	public MonMenu(OpenFileListener ouvrirListener, SaveListener saveListener, SaveAsListener saveAsListener, CompileListener compileListener, AnalyseListener analyseListener) {
		super("Fichier");
		itemFermer = new MonMenuItem("Fermer");
		itemOuvrir = new MonMenuItem("Open");
		itemSave = new MonMenuItem("Save");
		itemSaveAs = new MonMenuItem("Save as");
		itemNew = new MonMenuItem("New");
		itemCompile = new MonMenuItem("Compiler");
		itemAnalyse = new MonMenuItem("Analyser");
		itemOuvrir.addActionListener(ouvrirListener);
		itemSave.addActionListener(saveListener);
		itemSaveAs.addActionListener(saveAsListener);
		itemCompile.addActionListener(compileListener);
		itemAnalyse.addActionListener(analyseListener);
		add(itemNew);
		add(itemOuvrir);
		add(itemSave);
		add(itemSaveAs);
		add(itemFermer);
		add(itemCompile);
		add(itemAnalyse);
	}

}
