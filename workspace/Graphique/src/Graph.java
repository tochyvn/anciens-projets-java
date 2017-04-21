import java.awt.Color;
import java.awt.Point;

import javax.swing.*;
public class Graph {
	
	public  static void main(String [] args){
	
	JFrame fent = new JFrame();
	fent.setTitle("Book");
	fent.setSize(700, 500);
	Point pts = new Point(400,350);
	fent.setLocation(pts);
	
	JButton jb = new JButton("Un boutton de test");

	jb.setSize(90,70);
	
	JPanel jp = new JPanel();
	jp.setBackground(Color.pink);
	jp.add(jb);
	fent.add(jp);
	
	
	fent.setVisible(true);
	fent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
