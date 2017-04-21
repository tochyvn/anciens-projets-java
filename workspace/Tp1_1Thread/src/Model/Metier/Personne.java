package Model.Metier;

public class Personne {
	private char dossard;
	private int position;
	public Personne(char dossard) {
		this.dossard = dossard;
		position = 0;
	}
	
	public void avancer() {
		position++;
	}

	public char getDossard() {
		return dossard;
	}

	public void setDossard(char dossard) {
		this.dossard = dossard;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	

}

