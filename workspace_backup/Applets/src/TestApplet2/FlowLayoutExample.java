package TestApplet2;

import java.awt.*;
import javax.swing.*;

/**
 * @author David Matuszek
 * @version Nov 5, 2004
 */
public class FlowLayoutExample extends JApplet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void init () {
    getContentPane().setLayout(new FlowLayout ()); // default
    getContentPane().add(new JButton("One"));
    getContentPane().add(new JButton("Two"));
    getContentPane().add(new JButton("Three"));
    getContentPane().add(new JButton("Four"));
    getContentPane().add(new JButton("Five"));
    getContentPane().add(new JButton("Six"));
  }
}

