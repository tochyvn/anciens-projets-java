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
public class User_poste_direction {
	public User_poste_direction() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USER_POSTE_DIRECTION_USER) {
			return ORM_user;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_poste;
	
	private String libelle;
	
	private java.util.Set ORM_user = new java.util.HashSet();
	
	private void setId_poste(int value) {
		this.id_poste = value;
	}
	
	public int getId_poste() {
		return id_poste;
	}
	
	public int getORMID() {
		return getId_poste();
	}
	
	public void setLibelle(String value) {
		this.libelle = value;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	private void setORM_User(java.util.Set value) {
		this.ORM_user = value;
	}
	
	private java.util.Set getORM_User() {
		return ORM_user;
	}
	
	public final UserSetCollection user = new UserSetCollection(this, _ormAdapter, ORMConstants.KEY_USER_POSTE_DIRECTION_USER, ORMConstants.KEY_USER_ID_POSTE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_poste());
	}
	
}
