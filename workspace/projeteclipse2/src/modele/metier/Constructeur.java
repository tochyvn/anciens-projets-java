package modele.metier;

import java.util.ArrayList;

public class Constructeur {
	
	private String name;
	private int portee;
	private ArrayList<Parametre> mesParams;

	public Constructeur(String name,int portee) {
		mesParams = new ArrayList<Parametre>();
		this.portee = portee;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public ArrayList<Parametre> getMesParams() {
		return mesParams;
	}

	public void addParameter(Parametre parametre) {
		this.mesParams.add(parametre);
	}

}
