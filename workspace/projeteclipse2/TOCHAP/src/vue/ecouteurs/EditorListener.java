package vue.ecouteurs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditorListener implements KeyListener {

	public EditorListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("la touché pressée est "+e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("la touché pressée est "+e.getKeyChar());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("la touché pressée est "+e.getKeyChar());
	}

}
