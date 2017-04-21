/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
public class Client {
	public Client() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CLIENT_ID_DEMANDE_RESERVATION) {
			return ORM_id_demande_reservation;
		}
		else if (key == ORMConstants.KEY_CLIENT_FACTURE) {
			return ORM_facture;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_client;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private String code_postal;
	
	private String ville;
	
	private String pays;
	
	private String login;
	
	private String password;
	
	private String cb_num;
	
	private String cb_date_exp;
	
	private String cb_chiffres_derriere;
	
	private java.util.Set ORM_id_demande_reservation = new java.util.HashSet();
	
	private java.util.Set ORM_facture = new java.util.HashSet();
	
	private void setId_client(int value) {
		this.id_client = value;
	}
	
	public int getId_client() {
		return id_client;
	}
	
	public int getORMID() {
		return getId_client();
	}
	
	public void setNom(String value) {
		this.nom = value;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setPrenom(String value) {
		this.prenom = value;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setAdresse(String value) {
		this.adresse = value;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setCode_postal(String value) {
		this.code_postal = value;
	}
	
	public String getCode_postal() {
		return code_postal;
	}
	
	public void setVille(String value) {
		this.ville = value;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setPays(String value) {
		this.pays = value;
	}
	
	public String getPays() {
		return pays;
	}
	
	public void setLogin(String value) {
		this.login = value;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setCb_num(String value) {
		this.cb_num = value;
	}
	
	public String getCb_num() {
		return cb_num;
	}
	
	public void setCb_date_exp(String value) {
		this.cb_date_exp = value;
	}
	
	public String getCb_date_exp() {
		return cb_date_exp;
	}
	
	public void setCb_chiffres_derriere(String value) {
		this.cb_chiffres_derriere = value;
	}
	
	public String getCb_chiffres_derriere() {
		return cb_chiffres_derriere;
	}
	
	private void setORM_Id_demande_reservation(java.util.Set value) {
		this.ORM_id_demande_reservation = value;
	}
	
	private java.util.Set getORM_Id_demande_reservation() {
		return ORM_id_demande_reservation;
	}
	
	public final Demande_reservationSetCollection id_demande_reservation = new Demande_reservationSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENT_ID_DEMANDE_RESERVATION, ORMConstants.KEY_DEMANDE_RESERVATION_ID_CLIENT, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Facture(java.util.Set value) {
		this.ORM_facture = value;
	}
	
	private java.util.Set getORM_Facture() {
		return ORM_facture;
	}
	
	public final FactureSetCollection facture = new FactureSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENT_FACTURE, ORMConstants.KEY_FACTURE_ID_CLIENT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_client());
	}
	
}
