package Fourmis;


import Fourmilière.Fourmiliere;


/**
 * 
 * @author Tochap
 *
 */
public abstract class Fourmi {
	/**
	 * represente la position d'une fourmi par rapport &agrave; la fourmili&egrave;re
	 */
	protected int position = 0;
	/**
	 * represente le cycle de vie d'une fourmi
	 */
	protected int cycleVie;
	/**
	 * repr&eacute;sente le num&eacute;ro d'une fourmi
	 */
	protected int numero;
	/**
	 * Constructeur de la classe fourmi
	 * @param cycleVie initialise le cycle de vie de la fourmi
	 */
	public Fourmi(int cycleVie) {
		this.cycleVie = cycleVie;
	}
	/**
	 * methode permettant d'obtenir la position d'une fourmi
	 * @return retourne la position d'une fourmi
	 */
	public int getPosition() {
		return position;
	}
    /**
     * Methode permettant de modifier la valeur de la position d'une fourmi par 
     * la valeur rentr&eacute;e en param&egrave;tre
     * @param position represente la valeur &agrave; donner &agrave; la position d'une fourmi
     */
	public void setPosition(int position) {
		this.position = position;
	}
    /**
     * Methode permettant d'acc&eacute;der &agrave; la valeur du cycle de vie d'une fourmi
     * @return retourne le cycle de vie d'une fourmi
     */
	public int getCycleVie() {
		return cycleVie;
	}
    /**
     * Methode permettant de modifier la valeur du cycle de vie d'une fourmi
     * par la valeur entr&eacute;e en param&egrave;tre
     * @param cycleVie represente la valeur &agrave; donner au cycle de vie de la fourmi
     */
	public void setCycleVie(int cycleVie) {
		this.cycleVie = cycleVie;
	}
	/**
     * Methode permettant d'acc&eacute;der &agrave; la valeur du num&eacute;ro d'une fourmi
     * @return retourne le num&eacute;ro d'une fourmi
     */
    public int getNumero() {
		return numero;
	}
    /**
     * Methode permettant de modifier la valeur du num&eacute;ro d'une fourmi
     * par la valeur entr&eacute;e en param&egrave;tre
     * @param numero represente la valeur &agrave; donner au num&eacute;ro de la fourmi
     */
	public void setNumero(int numero) {
		this.numero = numero;
	}
    /**
     * Methode retournant le type, le numero et la position de la fourmi
     * @return retourne le type de la fourmi son numero et sa position
     */
	public String afficheInfoFourmi() {
		return "La fourmi ("+getClass().getSimpleName()+" "+numero+" && vie = "+cycleVie+" && position = "+position+")";
	}
	/**
	 * Methode permettant &agrave; une fourmi d'avoir des comportement diff&eacute;rent selon le type de fourmi
	 * @param f permettant de sp&eacute;cifier la fourmili&egrave;re
	 */
	public abstract void comportement(Fourmiliere f);
    /**
     * Methode renvoyant l'etat d'une fourmi par rapport &agrave; son cycle de vie et &agrave; sa position
     * @return retourne l'etat de type Enumeration( INACTIVE, LIBRE, OCCUPEE)
     */
	public Etat etat() {
		Etat etat = null;
		//si son cycle de vie est egale à O
		if (cycleVie == 0) {
			//if (position != 0)
			  etat = Etat.INACTIVE;
		}
		//sinon
		else {
			if (position == 0)
				etat = Etat.LIBRE;
			else
				etat = Etat.OCCUPEE;
		}
		return etat; 
		
	}
	
}
