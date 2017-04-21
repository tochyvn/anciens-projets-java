package package1;

public class Joueur {
	
	private String nom;
	private int score;

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", score=" + score + "]";
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Joueur(String nom) {
		
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	

}
