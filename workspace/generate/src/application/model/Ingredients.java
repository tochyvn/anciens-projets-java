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
public class Ingredients {
	public Ingredients() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_INGREDIENTS_ID_PRODUIT) {
			return ORM_id_produit;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_ingredient;
	
	private String libelle;
	
	private Double prix;
	
	private java.util.Set ORM_id_produit = new java.util.HashSet();
	
	private void setId_ingredient(int value) {
		this.id_ingredient = value;
	}
	
	public int getId_ingredient() {
		return id_ingredient;
	}
	
	public int getORMID() {
		return getId_ingredient();
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
	
	public final ProduitsSetCollection id_produit = new ProduitsSetCollection(this, _ormAdapter, ORMConstants.KEY_INGREDIENTS_ID_PRODUIT, ORMConstants.KEY_PRODUITS_ID_INGREDIENT, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_ingredient());
	}
	
}
