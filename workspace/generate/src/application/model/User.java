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
public class User {
	public User() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_USER_ID_POSTE) {
			this.id_poste = (User_poste_direction) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_user;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private String code_postal;
	
	private String login;
	
	private String password;
	
	private User_poste_direction id_poste;
	
	private void setId_user(int value) {
		this.id_user = value;
	}
	
	public int getId_user() {
		return id_user;
	}
	
	public int getORMID() {
		return getId_user();
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
	
	public void setId_poste(User_poste_direction value) {
		if (id_poste != null) {
			id_poste.user.remove(this);
		}
		if (value != null) {
			value.user.add(this);
		}
	}
	
	public User_poste_direction getId_poste() {
		return id_poste;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_poste(User_poste_direction value) {
		this.id_poste = value;
	}
	
	private User_poste_direction getORM_Id_poste() {
		return id_poste;
	}
	
	public String toString() {
		return String.valueOf(getId_user());
	}
	
}
