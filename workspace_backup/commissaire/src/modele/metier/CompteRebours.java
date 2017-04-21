package modele.metier;

public class CompteRebours {
	
	private int time;
	public static final int MAX=10;
	
	public CompteRebours() {
		time = MAX;
	}

	public int getTime() {
		return time;
	}

	public void decTime() {
		time--;
	}
	
	
}
