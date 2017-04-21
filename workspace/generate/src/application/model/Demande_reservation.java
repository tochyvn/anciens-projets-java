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
public class Demande_reservation {
	public Demande_reservation() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_DEMANDE_RESERVATION_ID_CLIENT) {
			return ORM_id_client;
		}
		else if (key == ORMConstants.KEY_DEMANDE_RESERVATION_CONFIRMATION) {
			return ORM_confirmation;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_DEMANDE_RESERVATION_ID_CHAMBRE) {
			this.id_chambre = (Chambre) owner;
		}
		
		else if (key == ORMConstants.KEY_DEMANDE_RESERVATION_ID_CONFIRMATION) {
			this.id_confirmation = (Confirmation) owner;
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
	
	private int id_demande_reservation;
	
	private java.util.Date date_arrive;
	
	private java.util.Date date_sortie;
	
	private java.util.Date date_chambre_tarif;
	
	private Double tarif;
	
	private Chambre id_chambre;
	
	private Confirmation id_confirmation;
	
	private java.util.Set ORM_id_client = new java.util.HashSet();
	
	private java.util.Set ORM_confirmation = new java.util.HashSet();
	
	private void setId_demande_reservation(int value) {
		this.id_demande_reservation = value;
	}
	
	public int getId_demande_reservation() {
		return id_demande_reservation;
	}
	
	public int getORMID() {
		return getId_demande_reservation();
	}
	
	public void setDate_arrive(java.util.Date value) {
		this.date_arrive = value;
	}
	
	public java.util.Date getDate_arrive() {
		return date_arrive;
	}
	
	public void setDate_sortie(java.util.Date value) {
		this.date_sortie = value;
	}
	
	public java.util.Date getDate_sortie() {
		return date_sortie;
	}
	
	public void setDate_chambre_tarif(java.util.Date value) {
		this.date_chambre_tarif = value;
	}
	
	public java.util.Date getDate_chambre_tarif() {
		return date_chambre_tarif;
	}
	
	public void setTarif(double value) {
		setTarif(new Double(value));
	}
	
	public void setTarif(Double value) {
		this.tarif = value;
	}
	
	public Double getTarif() {
		return tarif;
	}
	
	private void setORM_Id_client(java.util.Set value) {
		this.ORM_id_client = value;
	}
	
	private java.util.Set getORM_Id_client() {
		return ORM_id_client;
	}
	
	public final ClientSetCollection id_client = new ClientSetCollection(this, _ormAdapter, ORMConstants.KEY_DEMANDE_RESERVATION_ID_CLIENT, ORMConstants.KEY_CLIENT_ID_DEMANDE_RESERVATION, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setId_chambre(Chambre value) {
		if (id_chambre != null) {
			id_chambre.demande_reservation.remove(this);
		}
		if (value != null) {
			value.demande_reservation.add(this);
		}
	}
	
	public Chambre getId_chambre() {
		return id_chambre;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_chambre(Chambre value) {
		this.id_chambre = value;
	}
	
	private Chambre getORM_Id_chambre() {
		return id_chambre;
	}
	
	public void setId_confirmation(Confirmation value) {
		if (id_confirmation != null) {
			id_confirmation.demande_reservation.remove(this);
		}
		if (value != null) {
			value.demande_reservation.add(this);
		}
	}
	
	public Confirmation getId_confirmation() {
		return id_confirmation;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_confirmation(Confirmation value) {
		this.id_confirmation = value;
	}
	
	private Confirmation getORM_Id_confirmation() {
		return id_confirmation;
	}
	
	private void setORM_Confirmation(java.util.Set value) {
		this.ORM_confirmation = value;
	}
	
	private java.util.Set getORM_Confirmation() {
		return ORM_confirmation;
	}
	
	public final ConfirmationSetCollection confirmation = new ConfirmationSetCollection(this, _ormAdapter, ORMConstants.KEY_DEMANDE_RESERVATION_CONFIRMATION, ORMConstants.KEY_CONFIRMATION_ID_DEMANDE_RESERVATION, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_demande_reservation());
	}
	
}
