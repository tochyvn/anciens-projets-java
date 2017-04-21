package Vue;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class Container extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MaBarProgression[] mesBars;
	public final static int nombreBars = 5;
	/**
	 * Constructeur
	 */
	
	public Container(LayoutManager layout) {
		super(layout);
		setBackground(Color.RED);
		mesBars = new MaBarProgression[nombreBars];
		mesBars[0] = new MaBarProgression(Color.BLACK);
		mesBars[1] = new MaBarProgression(Color.BLUE);
		mesBars[2] = new MaBarProgression(Color.GREEN);
		mesBars[3] = new MaBarProgression(Color.ORANGE);
		mesBars[4] = new MaBarProgression(Color.CYAN);
		this.addMesBars();
	}
	
	private void addMesBars() {
		for (MaBarProgression maBarProgression : mesBars) {
			this.add(maBarProgression);
		}
	}

	public MaBarProgression[] getMesBars() {
		return mesBars;
	}

	public void setMesBars(MaBarProgression[] mesBars) {
		this.mesBars = mesBars;
	}
	
	
	
	
}
