package Tp3;

public class Ouvrier extends FourmiMobile{

	public Ouvrier(int cycleVie) {
		super(cycleVie);
		this.setVitesse(1);
	}

	@Override
	public void deplacer() {
		this.setPosition(this.getVitesse()); 
		System.out.println(this.getPosition() + "Ouvrier");
	}

	@Override
	public void faireMission(Site cible) {
		this.setEtat(ETAT.OCCUPEE);
		this.setDestination(cible);
	}
	
	

}
