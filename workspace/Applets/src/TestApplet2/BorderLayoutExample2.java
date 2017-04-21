package TestApplet2;

import java.awt.*;
//import java.applet.*;
import javax.swing.*;

/**
 * @author David Matuszek
 * @version Nov 5, 2004
 */
public class BorderLayoutExample2 extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public static void main(String[] args) {
      BorderLayoutExample2 frame = new BorderLayoutExample2();
      frame.doSomething();
  }

  void doSomething() {
    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    c.add(new JButton("One"),   BorderLayout.NORTH);
    c.add(new JButton("Two"),   BorderLayout.WEST);
    c.add(new JButton("Three"), BorderLayout.CENTER);
    c.add(new JButton("Four"),  BorderLayout.EAST);
    c.add(new JButton("Five"),  BorderLayout.SOUTH);
    c.add(new JButton("Six"),   BorderLayout.SOUTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }
}
