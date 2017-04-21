package edi;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panneau extends JPanel{
	private JButton but;
	public Panneau(OuvrirListener al) {
		super();
		but = new JButton("ouverture");
		but.addActionListener(al);
		setBackground(Color.gray);
		add(but);
	}

}
