package Vue;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container c1;
	public static final int cols = 1;
	private static final int lonr = 800;
	private static final int larg = 400;
	
	public Fenetre() throws HeadlessException {
		super("Hippodrome");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c1 = new Container(new GridLayout(Container.nombreBars, cols));
		getContentPane().add(c1);
		setSize(lonr, larg);
		setLocation(400, 200);
		setVisible(true);
	}

	public Container getC1() {
		return c1;
	}

	public void setC1(Container c1) {
		this.c1 = c1;
	}
	

}
