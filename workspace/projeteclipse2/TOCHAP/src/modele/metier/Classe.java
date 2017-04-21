package modele.metier;

import java.util.ArrayList;

public class Classe {
	
	private String source;
	private String erreur;
	private String name;
	private ArrayList<Attribut> mesAttributs;
	private ArrayList<Methode> mesMethodes;
	private ArrayList<Constructeur> mesConstructeurs;

	public Classe(String source, String name) {
		this.name = name;
		this.source = source;
		this.erreur = "";
		mesAttributs = new ArrayList<Attribut>();
		mesMethodes = new ArrayList<Methode>();
		mesConstructeurs = new ArrayList<Constructeur>();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Attribut> getMesAttributs() {
		return mesAttributs;
	}

	public void addAttribut(Attribut attribut) {
		this.mesAttributs.add(attribut);
	}

	public ArrayList<Methode> getMesMethodes() {
		return mesMethodes;
	}

	public void addMethode(Methode methode) {
		this.mesMethodes.add(methode);
	}
	
	public ArrayList<Constructeur> getMesConstructeurs() {
		return mesConstructeurs;
	}

	public void addConstructeur(Constructeur constructeur) {
		this.mesConstructeurs.add(constructeur);
	}
	
}
