package Tp3;

public class Reine extends Fourmi{
    
	
	
	public Reine(int cycleVie) {
		super(cycleVie);
		this.faireNaitre();
		
	}

	public void faireNaitre() {
		for(int i=0;i<5;i++){
			Fourmilière.fourmis.add(new Ouvrier(45));
		}
		
		for(int i=0;i<5;i++){
			Fourmilière.fourmis.add(new Soldat(45));
		}
		
		for(int i=0;i<5;i++){
			Fourmilière.fourmis.add(new Soigneur(45));
		}
	}

}
