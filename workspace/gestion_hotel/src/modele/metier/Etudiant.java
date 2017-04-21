package modele.metier;

import modele.technique.Validator;

public class Etudiant {

	private int identifiant;
	private String reference;
	private String nom;
	private String prenom;
	private String specialite;
	
	public Etudiant() {
		super();
	}

	public Etudiant(String reference, String nom, String prenom, String specialite) throws EtudiantException{
		super();
		if ( Validator.isEmpty(reference) ) {
			throw new EtudiantException("Le champ [ REFERENCE ] ne doit pas &circ;tre vide");
		}
		if ( Validator.isEmpty(nom) )
			throw new EtudiantException("Le champ [ NOM ] ne doit pas �tre vide");
		
		if ( Validator.isEmpty(prenom) )
			throw new EtudiantException("Le champ [ PRENOM ] ne doit pas �tre vide");
		
		if ( Validator.isEmpty(specialite) )
			throw new EtudiantException("Le champ [ SPECIALITE ] ne doit pas �tre vide");
		else {
			this.reference = reference;
			this.nom = nom;
			this.prenom = prenom;
			this.specialite = specialite;
		}
		
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
	
	/**
	public static void main(String[] args) {
		Etudiant etudiant = null;
		try {
			etudiant = new Etudiant("qdsdqsddsd", "", "", "");
		} catch (EtudiantException e) {}
		finally {
			if (etudiant == null) {
				etudiant = new Etudiant();
			}
		}
		System.out.println(etudiant.toString());
	}
	*/
	@Override
	public String toString() {
		return "Etudiant [identifiant=" + identifiant + ", reference=" + reference + ", nom=" + nom + ", prenom="
				+ prenom + ", specialite=" + specialite + "]";
	}
	
	
	
}
