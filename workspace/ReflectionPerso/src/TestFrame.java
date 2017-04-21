import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TestFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar menuBar = new JMenuBar();
    JMenu mnuFile = new JMenu("File");
    JMenuItem mnuNewFile = new JMenuItem("New File");
    JMenu mnuEdit = new JMenu("Edit");
    JMenuItem mnuUndo = new JMenuItem("Undo");
    JMenuItem mnuRedo = new JMenuItem("Redo");
    JMenuItem mnuCopy = new JMenuItem("Copy");
    JMenuItem mnuCut = new JMenuItem("Cut");
    JMenuItem mnuPaste = new JMenuItem("Paste");
    JMenuItem mnuOpenFile = new JMenuItem("Open File ...");
    JMenuItem mnuSaveFile = new JMenuItem("Save File ...");
    JMenuItem mnuSaveFileAs = new JMenuItem("Save File As ...");
    JMenu mnuHelp = new JMenu("Help");

	public TestFrame() {
		// Mise en place du conteneur de sous-fenêtres
	    JDesktopPane desktopPane = new JDesktopPane();
	    desktopPane.setBackground(Color.gray);
	    desktopPane.setLayout(new FlowLayout());
	    JPanel contentPane = (JPanel)this.getContentPane();
	    contentPane.add(desktopPane, FlowLayout.LEFT);

	    // Construction de la barre de menu
	    this.createMenuBar();

	    // Creation d'une sous-fenêtre
	    JInternalFrame f2 = new JInternalFrame("Seconde fenêtre");
	    f2.setSize(300,200);
	    f2.setVisible(true);
	    f2.setResizable(true);
	    f2.setLocation(20,20);
	    desktopPane.add( f2 );

	    // Creation d'une autre sous-fenêtre
	    JInternalFrame f1 = new JInternalFrame("Première fenêtre");
	    f1.setSize(300,200);
	    f1.setVisible(true);
	    f1.setResizable(true);
	    desktopPane.add( f1 );

	    // Autres Décorations
	    contentPane.add(new JTree(), BorderLayout.WEST);
	    contentPane.add(new JLabel("La barre de status"), BorderLayout.SOUTH);

	    this.setSize(500,400);

	    // Quelques évènements
	    this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent evt) {
	            setVisible(false);
	            dispose();
	            System.exit(0);
	        }
	    });
	    
	}
	
	/** Methode de construction de la barre de menu */
    private void createMenuBar() {
        this.setJMenuBar(menuBar);
        mnuFile.add(mnuNewFile);
        mnuFile.add(mnuOpenFile);
        mnuFile.add(mnuSaveFile);
        mnuFile.add(mnuSaveFileAs);
        mnuEdit.add(mnuUndo);
        mnuEdit.add(mnuRedo);
        mnuEdit.addSeparator();
        mnuEdit.add(mnuCopy);
        mnuEdit.add(mnuCut);
        mnuEdit.add(mnuPaste);

        menuBar.add(mnuFile);
        menuBar.add(mnuEdit);
        menuBar.add(mnuHelp);
        
    }
    
    
    
    
    public static void main(String[] args) {
        TestFrame frame = new TestFrame();
        frame.setVisible(true);
    }
}






   