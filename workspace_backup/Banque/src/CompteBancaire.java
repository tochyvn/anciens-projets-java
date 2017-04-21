/**
 * 
 * @author silnti
 *
 */
public class CompteBancaire {
	private String code; 
	private double solde;
	
	/**
	 * Constructeur par defaut de la classe CompteBancaire
	 */
	public CompteBancaire() {
		super();
	}

    /**
     * Constructeur avec paramètre de la classe CompteBancaire
     * @param code numero du compte
     * @param solde solde dans le compte
     */
	public CompteBancaire(String code, double solde) {
		super();
		this.code = code;
		this.solde = solde;
	}
    /**
     * Methode permettant d'obtenir le numero d'un compte
     * @return retourne le numero d'un compte
     */
	public String getCode() {
		return code;
	}
    /**
     * Methode permettant de modifier la valeur du du code d'un compte
     * @param code nouvelle valeur du code compte 
     */
	public void setCode(String code) {
		this.code = code;
	}
    /**
     * Methode permettant d'obtenir la valeur du solde
     * @return retourne la valeur du solde
     */
	public double getSolde() {
		return solde;
	}
    /**
     * Methode permettant de modifier la valeur du solde
     * @param solde nouvelle valeur du solde 
     */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	/**
	 * methode permettant l'affichage d'un numero de compte et son solde
	 */
	public String toString() {
		
		return "code = "+code+" solde = "+solde;
	}
	
	
	
	
	
	

}
