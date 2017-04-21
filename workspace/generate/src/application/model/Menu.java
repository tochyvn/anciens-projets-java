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
public class Menu {
	public Menu() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_MENU_ID_PRODUIT) {
			return ORM_id_produit;
		}
		else if (key == ORMConstants.KEY_MENU_LIGNE_FACTURE) {
			return ORM_ligne_facture;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_menu;
	
	private String libelle;
	
	private Double prix;
	
	private java.util.Set ORM_id_produit = new java.util.HashSet();
	
	private java.util.Set ORM_ligne_facture = new java.util.HashSet();
	
	private void setId_menu(int value) {
		this.id_menu = value;
	}
	
	public int getId_menu() {
		return id_menu;
	}
	
	public int getORMID() {
		return getId_menu();
	}
	
	public void setLibelle(String value) {
		this.libelle = value;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setPrix(double value) {
		setPrix(new Double(value));
	}
	
	public void setPrix(Double value) {
		this.prix = value;
	}
	
	public Double getPrix() {
		return prix;
	}
	
	private void setORM_Id_produit(java.util.Set value) {
		this.ORM_id_produit = value;
	}
	
	private java.util.Set getORM_Id_produit() {
		return ORM_id_produit;
	}
	
	public final ProduitsSetCollection id_produit = new ProduitsSetCollection(this, _ormAdapter, ORMConstants.KEY_MENU_ID_PRODUIT, ORMConstants.KEY_PRODUITS_ID_MENU, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Ligne_facture(java.util.Set value) {
		this.ORM_ligne_facture = value;
	}
	
	private java.util.Set getORM_Ligne_facture() {
		return ORM_ligne_facture;
	}
	
	public final Ligne_factureSetCollection ligne_facture = new Ligne_factureSetCollection(this, _ormAdapter, ORMConstants.KEY_MENU_LIGNE_FACTURE, ORMConstants.KEY_LIGNE_FACTURE_ID_MENU, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_menu());
	}
	
}
