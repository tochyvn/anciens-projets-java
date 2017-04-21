package modele.metier;

public class EtudiantOld {
	
	private int identifiant;
	private String reference;
	private String nom;
	private String prenom;
	private String specialite;

	public EtudiantOld() {
		super();
	}
	
	public EtudiantOld(String reference, String nom, String prenom, String specialite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.reference = reference;
		this.specialite = specialite;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	
}
