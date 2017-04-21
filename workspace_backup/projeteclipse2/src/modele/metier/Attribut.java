package modele.metier;

public class Attribut extends Parametre {
	
	private int portee;

	public Attribut(String name, String type, int portee) {
		super(name, type);
		this.portee = portee;
	}
	
	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

}
