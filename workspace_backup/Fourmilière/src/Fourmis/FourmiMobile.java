package Fourmis;

import Fourmilière.Site;

public abstract class FourmiMobile extends Fourmi {
	
	public Site siteCible;     /*=================================================*/
	protected Boolean sens = true;
	protected int vitesse;
	protected Etat etat = Etat.LIBRE;
	/**
	 * 
	 * @param position
	 * @param cycleVie
	 * @param vitesse
	 */
    public FourmiMobile(int position, int cycleVie, int vitesse) {
		super(position, cycleVie);
		this.vitesse = vitesse;
	}
	/**
     * 
     * @return
     */
	public int getVitesse() {
		return vitesse;
	}
	/**
	 * 
	 * @param vitesse
	 */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	public Boolean getSens() {
		return sens;
	}
	public void setSens(Boolean sens) {
		this.sens = sens;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	/**
     * methode renvoyant le nom de la classe
     */
	public String toString() {
		return getClass().getSimpleName();
	}
	/**
     * 
     */
	public abstract void deplacer() ;
	
	protected void incrementer() {
		//
		if (sens == true) 
			setPosition(position+vitesse);
		//
		else 
			setPosition(position-vitesse);

	}

}
