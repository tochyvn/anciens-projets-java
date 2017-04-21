package Tp3;

import java.util.ArrayList;

public class Fourmilière {
	
	Site []sites = new Site[5];
	static ArrayList<Fourmi> fourmis = new ArrayList<Fourmi>();
	Fourmi reine;
	public int vie = 1;
	
	public Fourmilière() {
		reine = new Reine(this.vie);
		
		for(int i = 0; i<5; i++) {
			sites[i] = new Site(i+1);
			
		}
	}
	
	public void nouveauCycle() {
		
		for(Fourmi mesFourmis:fourmis) {
			
			FourmiMobile fourm = (FourmiMobile) mesFourmis;
			fourm.faireMission(sites[0]);
			
			
		}
	}
	
	public void bouger() {
		
		for(int i =0; i<5; i++) {
			for(Fourmi mesFourmis:fourmis) {
				
				FourmiMobile fourm = (FourmiMobile) mesFourmis;
			   if(fourm.getEtat()==ETAT.OCCUPEE)
				   fourm.deplacer();
				
			}
			
		}
	}

}
