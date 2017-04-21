package vue;

import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MaFenetre2 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree arbre;
	private DefaultMutableTreeNode racine;

	public MaFenetre2() throws HeadlessException {
		super("Liste des repertoires");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//On invoque la methode de construction de l'arbre
		listRoot();
		setVisible(true);
	}

	private void listRoot() {
		
		this.racine = new DefaultMutableTreeNode();
		int count = 0;
		for (File file : File.listRoots()) {
			DefaultMutableTreeNode lecteur = new DefaultMutableTreeNode(file.getAbsolutePath());
			for (File file1 : file.listFiles()) {
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(file1.getName()+"\\");
				lecteur.add(node);
			}
			//On ajoute les differents lecteurs à la racine
			this.racine.add(lecteur);
		}
		//On cree l'arbre
		this.arbre = new JTree(this.racine);
		this.getContentPane().add(arbre);
	}

	

}
