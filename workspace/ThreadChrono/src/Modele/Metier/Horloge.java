package Modele.Metier;

public class Horloge {
	
	private boolean sens;
	private int posAiguille;

	public Horloge(boolean sens, int postion) {
		this.sens = sens;
		posAiguille = postion;
	}
	
	public void avancer() {
		if (sens==true) {
			posAiguille++;
		}	
		else {
			posAiguille--;
		}	
	}


	public boolean isSens() {
		return sens;
	}

	public void setSens(boolean sens) {
		this.sens = sens;
	}

	public int getPosAiguille() {
		return posAiguille;
	}

	public void setPosAiguille(int posAiguille) {
		this.posAiguille = posAiguille;
	}

}
