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
public class Produits {
	public Produits() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PRODUITS_ID_MENU) {
			return ORM_id_menu;
		}
		else if (key == ORMConstants.KEY_PRODUITS_ID_INGREDIENT) {
			return ORM_id_ingredient;
		}
		else if (key == ORMConstants.KEY_PRODUITS_LIGNE_FACTURE) {
			return ORM_ligne_facture;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PRODUITS_ID_CATEGORIE) {
			this.id_categorie = (Categories) owner;
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
	
	private int id_produit;
	
	private String libelle;
	
	private Double prix;
	
	private Categories id_categorie;
	
	private java.util.Set ORM_id_menu = new java.util.HashSet();
	
	private java.util.Set ORM_id_ingredient = new java.util.HashSet();
	
	private java.util.Set ORM_ligne_facture = new java.util.HashSet();
	
	private void setId_produit(int value) {
		this.id_produit = value;
	}
	
	public int getId_produit() {
		return id_produit;
	}
	
	public int getORMID() {
		return getId_produit();
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
	
	private void setORM_Id_menu(java.util.Set value) {
		this.ORM_id_menu = value;
	}
	
	private java.util.Set getORM_Id_menu() {
		return ORM_id_menu;
	}
	
	public final MenuSetCollection id_menu = new MenuSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUITS_ID_MENU, ORMConstants.KEY_MENU_ID_PRODUIT, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setId_categorie(Categories value) {
		if (id_categorie != null) {
			id_categorie.produits.remove(this);
		}
		if (value != null) {
			value.produits.add(this);
		}
	}
	
	public Categories getId_categorie() {
		return id_categorie;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_categorie(Categories value) {
		this.id_categorie = value;
	}
	
	private Categories getORM_Id_categorie() {
		return id_categorie;
	}
	
	private void setORM_Id_ingredient(java.util.Set value) {
		this.ORM_id_ingredient = value;
	}
	
	private java.util.Set getORM_Id_ingredient() {
		return ORM_id_ingredient;
	}
	
	public final IngredientsSetCollection id_ingredient = new IngredientsSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUITS_ID_INGREDIENT, ORMConstants.KEY_INGREDIENTS_ID_PRODUIT, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Ligne_facture(java.util.Set value) {
		this.ORM_ligne_facture = value;
	}
	
	private java.util.Set getORM_Ligne_facture() {
		return ORM_ligne_facture;
	}
	
	public final Ligne_factureSetCollection ligne_facture = new Ligne_factureSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUITS_LIGNE_FACTURE, ORMConstants.KEY_LIGNE_FACTURE_ID_PRODUIT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_produit());
	}
	
}
