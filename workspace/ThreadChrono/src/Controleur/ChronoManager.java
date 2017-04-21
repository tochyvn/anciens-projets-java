package Controleur;

import java.util.ArrayList;

import Modele.Techniqhe.Chrono;
import Modele.Techniqhe.CompteRebours;
import Modele.Techniqhe.TypeChrono;
import Vue.Affichage;

public class ChronoManager {
	private Affichage vue;
	private ArrayList<TypeChrono> chronometres = new ArrayList<TypeChrono>();
	private static ChronoManager manager=null;
	public final static int CONST2=10;

	private ChronoManager() {
		chronometres.add(new CompteRebours("TEMPO",false,CONST2,CONST2));
		chronometres.add(new Chrono("CHRONO",true,CONST2,0));	
	}
	
	public static ChronoManager getInstance() {
		if (manager==null)
			manager = new ChronoManager();
		return manager;
		
	}
	
	public void affiche(String s) {
		if (vue != null)
			vue.affiche(s);
	}
	
	public void go() {
		for(int i=0; i<chronometres.size(); i++) 
			chronometres.get(i).start();
	}

	public Affichage getVue() {
		return vue;
	}

	public void setVue(Affichage vue) {
		this.vue = vue;
	}

}
