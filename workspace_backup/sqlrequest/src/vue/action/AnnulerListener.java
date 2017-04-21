package vue.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vue.composant.FenetreConnexion;


public class AnnulerListener extends MouseAdapter {
	
	private FenetreConnexion fenetreConnexion;

	public AnnulerListener(FenetreConnexion fenetreConnexion) {
		this.fenetreConnexion = fenetreConnexion;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		fenetreConnexion.setVisible(false);
	}
	
	

}
