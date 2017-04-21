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
public class Ligne_facture {
	public Ligne_facture() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_LIGNE_FACTURE_ID_FACTURE) {
			this.id_facture = (Facture) owner;
		}
		
		else if (key == ORMConstants.KEY_LIGNE_FACTURE_ID_MENU) {
			this.id_menu = (Menu) owner;
		}
		
		else if (key == ORMConstants.KEY_LIGNE_FACTURE_ID_PRODUIT) {
			this.id_produit = (Produits) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_ligne_facture;
	
	private Integer qtt_ligne;
	
	private Double ligne_montant;
	
	private Double ligne_taux;
	
	private Integer fk_id_facture;
	
	private Facture id_facture;
	
	private Integer qte;
	
	private Menu id_menu;
	
	private Integer qte_lig_fact_produits;
	
	private Produits id_produit;
	
	private void setId_ligne_facture(int value) {
		this.id_ligne_facture = value;
	}
	
	public int getId_ligne_facture() {
		return id_ligne_facture;
	}
	
	public int getORMID() {
		return getId_ligne_facture();
	}
	
	public void setQtt_ligne(int value) {
		setQtt_ligne(new Integer(value));
	}
	
	public void setQtt_ligne(Integer value) {
		this.qtt_ligne = value;
	}
	
	public Integer getQtt_ligne() {
		return qtt_ligne;
	}
	
	public void setLigne_montant(double value) {
		setLigne_montant(new Double(value));
	}
	
	public void setLigne_montant(Double value) {
		this.ligne_montant = value;
	}
	
	public Double getLigne_montant() {
		return ligne_montant;
	}
	
	public void setLigne_taux(double value) {
		setLigne_taux(new Double(value));
	}
	
	public void setLigne_taux(Double value) {
		this.ligne_taux = value;
	}
	
	public Double getLigne_taux() {
		return ligne_taux;
	}
	
	public void setFk_id_facture(int value) {
		setFk_id_facture(new Integer(value));
	}
	
	public void setFk_id_facture(Integer value) {
		this.fk_id_facture = value;
	}
	
	public Integer getFk_id_facture() {
		return fk_id_facture;
	}
	
	public void setQte(int value) {
		setQte(new Integer(value));
	}
	
	public void setQte(Integer value) {
		this.qte = value;
	}
	
	public Integer getQte() {
		return qte;
	}
	
	public void setQte_lig_fact_produits(int value) {
		setQte_lig_fact_produits(new Integer(value));
	}
	
	public void setQte_lig_fact_produits(Integer value) {
		this.qte_lig_fact_produits = value;
	}
	
	public Integer getQte_lig_fact_produits() {
		return qte_lig_fact_produits;
	}
	
	public void setId_facture(Facture value) {
		if (id_facture != null) {
			id_facture.ligne_facture.remove(this);
		}
		if (value != null) {
			value.ligne_facture.add(this);
		}
	}
	
	public Facture getId_facture() {
		return id_facture;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_facture(Facture value) {
		this.id_facture = value;
	}
	
	private Facture getORM_Id_facture() {
		return id_facture;
	}
	
	public void setId_menu(Menu value) {
		if (id_menu != null) {
			id_menu.ligne_facture.remove(this);
		}
		if (value != null) {
			value.ligne_facture.add(this);
		}
	}
	
	public Menu getId_menu() {
		return id_menu;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_menu(Menu value) {
		this.id_menu = value;
	}
	
	private Menu getORM_Id_menu() {
		return id_menu;
	}
	
	public void setId_produit(Produits value) {
		if (id_produit != null) {
			id_produit.ligne_facture.remove(this);
		}
		if (value != null) {
			value.ligne_facture.add(this);
		}
	}
	
	public Produits getId_produit() {
		return id_produit;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_produit(Produits value) {
		this.id_produit = value;
	}
	
	private Produits getORM_Id_produit() {
		return id_produit;
	}
	
	public String toString() {
		return String.valueOf(getId_ligne_facture());
	}
	
}
