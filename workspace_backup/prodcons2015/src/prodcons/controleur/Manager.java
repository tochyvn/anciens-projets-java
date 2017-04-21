package prodcons.controleur;

import prodcons.modele.technique.ConsommateurT;
import prodcons.modele.technique.Panier;
import prodcons.modele.technique.ProducteurT;
import prodcons.vue.Vue;

public final class Manager {
	private static Manager moi = new Manager();
	private ProducteurT pt;
	private ConsommateurT ct;
	private Panier p;
	private Vue vue;
	
	private Manager()
	{
		pt = new ProducteurT();
		ct = new ConsommateurT();
		p = new Panier();
		vue = null;
	}

	public static Manager getInstance()
	{
		return moi;
	}
	public void init(String s)
	{
		pt.setAp(s);
		ct.setAConsommer(s.length());
		pt.setPanier(p);
		ct.setPanier(p);
	}

	public void go()
	{
		pt.start();
		ct.start();
	}
	public void afficher(char ret) {
		if(vue != null)
		{
			vue.afficher(ret);
		}
		
	}
	public void setVue(Vue v)
	{
		vue = v;
	}
}
