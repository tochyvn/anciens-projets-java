package vue.composant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import vue.ecouteurs.AnalyseListener;
import vue.ecouteurs.CloseListener;
import vue.ecouteurs.CompileListener;
import vue.ecouteurs.OpenFileListener;
import vue.ecouteurs.SaveAsListener;
import vue.ecouteurs.SaveListener;

public class MaFenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MaBarreMenu barreMenu;
	private CloseListener fermer;
	private MonEditor editeurStandard;
	private MonEditor editeurError;
	private MonTabbedPane tab;
	private MonTree tree;
	private MonToolbar toolbar;
	
	
	
	public MaFenetre() throws HeadlessException {
		super("Editeur Java");
		tree = new MonTree();
		tab = new MonTabbedPane();
		editeurStandard = new MonEditor();
		editeurError = new MonEditor();
		editeurError.setText("AFFICHAGE DES ERREURS");
		editeurError.setBackground(Color.BLACK);
		editeurError.setForeground(Color.WHITE);
		
		setBounds(50, 50, 1000, 900);
		fermer = new CloseListener();
		addWindowListener(fermer);
		
		AnalyseListener analyseListener = new AnalyseListener(tab,tree);
		
		CompileListener compileListener = new CompileListener(tab);
		OpenFileListener ouvrirList = new OpenFileListener(tab,editeurStandard,editeurError);
		SaveListener saveListener = new SaveListener(tab, editeurStandard, editeurError);
		SaveAsListener saveAsListener = new SaveAsListener(tab, editeurStandard);
		//problème de focus
		editeurStandard.requestFocus();
		
		
		toolbar = new MonToolbar(ouvrirList, saveListener, saveAsListener, compileListener, analyseListener);
		barreMenu = new MaBarreMenu(ouvrirList,saveListener, saveAsListener, compileListener, analyseListener);
		add(toolbar,BorderLayout.NORTH);
		
		this.setJMenuBar(barreMenu);
		add(new MonSplitPane(editeurError,tree,tab));
		setVisible(true);
	}


}
