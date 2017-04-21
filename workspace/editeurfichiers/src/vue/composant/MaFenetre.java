package vue.composant;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MaFenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonMenuBar menuBar; 
	private MonSplit monSplitPane;
	
	public MaFenetre() throws HeadlessException {
		super("Ma fenêtre principale");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		menuBar = new MonMenuBar();
		monSplitPane = new MonSplit();
		this.setJMenuBar(menuBar);
		//this.getContentPane().add(monSplitPane);
		this.setVisible(true);
	}


}
