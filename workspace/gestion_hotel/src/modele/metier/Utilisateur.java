package modele.metier;

public class Utilisateur {
	
	private String nom;
	private String prenom;
	private CompteUtilisateur compte;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, CompteUtilisateur compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.compte = compte;
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

	public CompteUtilisateur getCompte() {
		return compte;
	}

	public void setCompte(CompteUtilisateur compte) {
		this.compte = compte;
	}
	
	

}
