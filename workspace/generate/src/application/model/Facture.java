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
public class Facture {
	public Facture() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_FACTURE_LIGNE_FACTURE) {
			return ORM_ligne_facture;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_FACTURE_ID_CLIENT) {
			this.id_client = (Client) owner;
		}
		
		else if (key == ORMConstants.KEY_FACTURE_ID_MODE_PAIEMENT) {
			this.id_mode_paiement = (Mode_paiement) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_facture;
	
	private Double prix_chambre;
	
	private Double prix_conso;
	
	private Double prix_total;
	
	private Integer fk_id_num_sejour;
	
	private Client id_client;
	
	private Mode_paiement id_mode_paiement;
	
	private java.util.Set ORM_ligne_facture = new java.util.HashSet();
	
	private void setId_facture(int value) {
		this.id_facture = value;
	}
	
	public int getId_facture() {
		return id_facture;
	}
	
	public int getORMID() {
		return getId_facture();
	}
	
	public void setPrix_chambre(double value) {
		setPrix_chambre(new Double(value));
	}
	
	public void setPrix_chambre(Double value) {
		this.prix_chambre = value;
	}
	
	public Double getPrix_chambre() {
		return prix_chambre;
	}
	
	public void setPrix_conso(double value) {
		setPrix_conso(new Double(value));
	}
	
	public void setPrix_conso(Double value) {
		this.prix_conso = value;
	}
	
	public Double getPrix_conso() {
		return prix_conso;
	}
	
	public void setPrix_total(double value) {
		setPrix_total(new Double(value));
	}
	
	public void setPrix_total(Double value) {
		this.prix_total = value;
	}
	
	public Double getPrix_total() {
		return prix_total;
	}
	
	public void setFk_id_num_sejour(int value) {
		setFk_id_num_sejour(new Integer(value));
	}
	
	public void setFk_id_num_sejour(Integer value) {
		this.fk_id_num_sejour = value;
	}
	
	public Integer getFk_id_num_sejour() {
		return fk_id_num_sejour;
	}
	
	public void setId_client(Client value) {
		if (id_client != null) {
			id_client.facture.remove(this);
		}
		if (value != null) {
			value.facture.add(this);
		}
	}
	
	public Client getId_client() {
		return id_client;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_client(Client value) {
		this.id_client = value;
	}
	
	private Client getORM_Id_client() {
		return id_client;
	}
	
	public void setId_mode_paiement(Mode_paiement value) {
		if (id_mode_paiement != null) {
			id_mode_paiement.facture.remove(this);
		}
		if (value != null) {
			value.facture.add(this);
		}
	}
	
	public Mode_paiement getId_mode_paiement() {
		return id_mode_paiement;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_mode_paiement(Mode_paiement value) {
		this.id_mode_paiement = value;
	}
	
	private Mode_paiement getORM_Id_mode_paiement() {
		return id_mode_paiement;
	}
	
	private void setORM_Ligne_facture(java.util.Set value) {
		this.ORM_ligne_facture = value;
	}
	
	private java.util.Set getORM_Ligne_facture() {
		return ORM_ligne_facture;
	}
	
	public final Ligne_factureSetCollection ligne_facture = new Ligne_factureSetCollection(this, _ormAdapter, ORMConstants.KEY_FACTURE_LIGNE_FACTURE, ORMConstants.KEY_LIGNE_FACTURE_ID_FACTURE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_facture());
	}
	
}
