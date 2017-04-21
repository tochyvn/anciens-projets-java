package TestApplet2;

import java.awt.*;
import javax.swing.*;

/**
 * @author David Matuszek
 * @version Nov 5, 2004
 */
public class App2Bout extends JApplet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void init() {
    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    JButton jb = new JButton("One"); jb.setSize(100,100);
    c.add(jb); 
    c.add(new JButton("Two"));
    c.add(new JButton("Three"), BorderLayout.CENTER);
    c.add(new JButton("Four"),  BorderLayout.EAST);
    c.add(new JButton("Five"),  BorderLayout.SOUTH);
    c.add(new JButton("Six"),   BorderLayout.SOUTH);
    
  }
}