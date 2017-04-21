package modele.metier;

public class Parametre {
	private String name;
	private String type;
	

	public Parametre(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}


}
