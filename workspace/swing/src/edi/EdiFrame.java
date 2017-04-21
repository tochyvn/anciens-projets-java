package edi;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.UnsupportedLookAndFeelException;

public class EdiFrame extends JFrame {
	private FermetureListener fl;
	private Panneau pan;
	private OuvrirListener ol;
	private EdiMenuBar emb;
	
	public EdiFrame() throws HeadlessException {
		super("editeur");
		DefaultMutableTreeNode racine;
		DefaultTreeCellRenderer dtcr= null;
		JEditorPane jp = new JEditorPane();
		JTabbedPane tb = new JTabbedPane();
		tb.add("titre",new JScrollPane(jp));
		dtcr = new DefaultTreeCellRenderer();
		URL url = this.getClass().getResource("./images/non.JPG");
		dtcr.setOpenIcon(new ImageIcon(url));
		racine = new DefaultMutableTreeNode("toutes les classes");
		DefaultMutableTreeNode c1 = new DefaultMutableTreeNode("MaClasse");
		DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("AutreClasse");
		racine.add(c1);
		racine.add(c2);
		JTree tree = new JTree(racine);
		tree.setRootVisible(false);
		tree.setCellRenderer(dtcr);
		DefaultMutableTreeNode attributs = new DefaultMutableTreeNode("attributs");
		attributs.add(new DefaultMutableTreeNode("PRIVE int i"));
		c1.add(attributs);
		c1.add(new DefaultMutableTreeNode("constructeurs"));
		c1.add(new DefaultMutableTreeNode("methodes"));
		ol = new OuvrirListener();
		emb = new EdiMenuBar(ol);
		fl = new FermetureListener();
//		pan = new Panneau(ol);
		setBounds(50, 50, 800, 600);
		setJMenuBar(emb);
//		add(pan);
		jp.setText(Manager.getInstance().getModele());
		add(new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(tree),tb),new JScrollPane(new JEditorPane())));
		addWindowListener(fl);
		LookAndFeelInfo[] lf = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo lookAndFeelInfo : lf) {
			System.out.println(lookAndFeelInfo.getName());
		}
			try {
				UIManager.setLookAndFeel(lf[3].getClassName());
				SwingUtilities.updateComponentTreeUI(this);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		setVisible(true);
	}

}
