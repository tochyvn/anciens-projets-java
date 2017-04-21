package vue;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MaFenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree monArbre;

	public MaFenetre() throws HeadlessException {
		super("MonArbre");
		setLocationRelativeTo(null);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		buildTree();
		setVisible(true);
	}

	private void buildTree() {
		//Arbre par defaut
		//monArbre = new JTree();
		//this.add(monArbre,BorderLayout.CENTER);
		
		//Creation d'une racine
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("Racine");
		
		//Nous allons ajouter des branches et des feuilles a notre racine
		for(int i=0; i<12; i++) {
		DefaultMutableTreeNode rep = new DefaultMutableTreeNode("Noeud n°"+i);
			
		//si le nbre est paire on ajoute une branche
			if (i%2 == 0)
				for (int j=0; j<5; j++) {
					DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode("Fichier-enfant n°"+j);
					
					//On ajoute enfin des feuilles
					for (int k=0; k<5; k++)  {
						rep2.add(new DefaultMutableTreeNode("Sous-fichier-enfant n°"+k));
						
					}//fin for k
					
					rep.add(rep2);
				
				}//fin for j
			
			racine.add(rep);
		
		}//fin for i
		
		//On cree notre arbre
		monArbre = new JTree(racine);
		this.getContentPane().add(new JScrollPane(monArbre),BorderLayout.NORTH);
	}
	
	
}
