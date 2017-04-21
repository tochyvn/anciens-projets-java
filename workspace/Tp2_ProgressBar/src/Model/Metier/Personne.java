package Model.Metier;

public class Personne {
	private String name;
	private int position;
	public Personne(String name) {
		this.name = name;
		position = 0;
	}
	
	public void avancer() {
		position++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	

}

