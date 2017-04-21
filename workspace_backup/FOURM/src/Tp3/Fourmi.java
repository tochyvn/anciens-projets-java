package Tp3;

public abstract class Fourmi {
    
	private type
	private int position=0;
	private int cycleVie;
	private ETAT etat=ETAT.LIBRE;
	
	public Fourmi(int cycleVie) {
		this.cycleVie = cycleVie;
		
	
		
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = this.position+position;
	}

	public int getCycleVie() {
		return cycleVie;
	}

	public void setCycleVie(int cycleVie) {
		this.cycleVie = cycleVie;
	}

	public ETAT getEtat() {
		return etat;
	}

	public void setEtat(ETAT etat) {
		this.etat = etat;
	}
	
	
	
	
	
	
	
}
