package tochap;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	MonProgressBar monProgress;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Panneau() {
		super(new FlowLayout());
		this.setBackground(Color.RED);
		this.setLocation(100, 100);
		monProgress = new MonProgressBar(5, 100);
		this.add(monProgress);
		//this.testerProgress();
	}
	
	public void testerProgress() {
		for (int i=0; i<100; i++) {
			monProgress.setValue(i);
			//monProgress.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
