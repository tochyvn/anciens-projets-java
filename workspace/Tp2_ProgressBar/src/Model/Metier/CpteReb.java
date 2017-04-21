package Model.Metier;

public class CpteReb {
	private int time;
	private static final int MAX=10;
	
	public CpteReb() {
		setTime(0);
	}
	
	public void avancer() {
		time--;
	}
	
	public boolean isFini() {
		return time>MAX;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public static int getMax() {
		return MAX;
	}
}
