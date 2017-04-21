package Tp3;

public class Soldat extends FourmiMobile {

	public Soldat(int cycleVie) {
		super(cycleVie);
		this.setVitesse(2);
	}

	@Override
	public void deplacer() {
		this.setPosition(this.getVitesse());
		System.out.println(this.getPosition() + "Soldat");
		
	}

	@Override
	public void faireMission(Site cible) {
		this.setEtat(ETAT.OCCUPEE);
		this.setDestination(cible);
		
	}

}
