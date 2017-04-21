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
public class Mode_paiement {
	public Mode_paiement() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_MODE_PAIEMENT_FACTURE) {
			return ORM_facture;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_mode_paiement;
	
	private String libelle;
	
	private java.util.Set ORM_facture = new java.util.HashSet();
	
	private void setId_mode_paiement(int value) {
		this.id_mode_paiement = value;
	}
	
	public int getId_mode_paiement() {
		return id_mode_paiement;
	}
	
	public int getORMID() {
		return getId_mode_paiement();
	}
	
	public void setLibelle(String value) {
		this.libelle = value;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	private void setORM_Facture(java.util.Set value) {
		this.ORM_facture = value;
	}
	
	private java.util.Set getORM_Facture() {
		return ORM_facture;
	}
	
	public final FactureSetCollection facture = new FactureSetCollection(this, _ormAdapter, ORMConstants.KEY_MODE_PAIEMENT_FACTURE, ORMConstants.KEY_FACTURE_ID_MODE_PAIEMENT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_mode_paiement());
	}
	
}
