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
public class Confirmation {
	public Confirmation() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CONFIRMATION_DEMANDE_RESERVATION) {
			return ORM_demande_reservation;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_CONFIRMATION_ID_DEMANDE_RESERVATION) {
			this.id_demande_reservation = (Demande_reservation) owner;
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
	
	private Byte confirmation;
	
	private java.util.Date date_confirmation;
	
	private int id_confirmation;
	
	private Demande_reservation id_demande_reservation;
	
	private java.util.Set ORM_demande_reservation = new java.util.HashSet();
	
	public void setConfirmation(byte value) {
		setConfirmation(new Byte(value));
	}
	
	public void setConfirmation(Byte value) {
		this.confirmation = value;
	}
	
	public Byte getConfirmation() {
		return confirmation;
	}
	
	public void setDate_confirmation(java.util.Date value) {
		this.date_confirmation = value;
	}
	
	public java.util.Date getDate_confirmation() {
		return date_confirmation;
	}
	
	private void setId_confirmation(int value) {
		this.id_confirmation = value;
	}
	
	public int getId_confirmation() {
		return id_confirmation;
	}
	
	public int getORMID() {
		return getId_confirmation();
	}
	
	public void setId_demande_reservation(Demande_reservation value) {
		if (id_demande_reservation != null) {
			id_demande_reservation.confirmation.remove(this);
		}
		if (value != null) {
			value.confirmation.add(this);
		}
	}
	
	public Demande_reservation getId_demande_reservation() {
		return id_demande_reservation;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Id_demande_reservation(Demande_reservation value) {
		this.id_demande_reservation = value;
	}
	
	private Demande_reservation getORM_Id_demande_reservation() {
		return id_demande_reservation;
	}
	
	private void setORM_Demande_reservation(java.util.Set value) {
		this.ORM_demande_reservation = value;
	}
	
	private java.util.Set getORM_Demande_reservation() {
		return ORM_demande_reservation;
	}
	
	public final Demande_reservationSetCollection demande_reservation = new Demande_reservationSetCollection(this, _ormAdapter, ORMConstants.KEY_CONFIRMATION_DEMANDE_RESERVATION, ORMConstants.KEY_DEMANDE_RESERVATION_ID_CONFIRMATION, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_confirmation());
	}
	
}
