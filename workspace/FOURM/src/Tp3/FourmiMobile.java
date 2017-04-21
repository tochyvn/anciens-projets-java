package Tp3;

public abstract class FourmiMobile extends Fourmi{

	private int vitesse;
    private Site destination;
    private boolean sens = true;
	
	public FourmiMobile(int cycleVie) {
		super(cycleVie);
		
	}

    public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public abstract void deplacer();

    public abstract void faireMission(Site cible);

	public Site getDestination() {
		return destination;
	}

	public void setDestination(Site destination) {
		this.destination = destination;
	}

	public boolean isSens() {
		return sens;
	}

	public void setSens(boolean sens) {
		this.sens = sens;
	}

}
