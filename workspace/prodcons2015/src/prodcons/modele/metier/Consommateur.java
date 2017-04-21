package prodcons.modele.metier;

import prodcons.modele.technique.Panier;

public class Consommateur {
	private Panier p;
	private int aConsommer;
	private int i;
	public Consommateur() {
		p = null;
		aConsommer=0;
		i = 0;
	}
	
	public void setPanier(Panier p)
	{
		this.p = p;
	}

	public int getaConsommer() {
		return aConsommer;
	}

	public void setaConsommer(int aConsommer) {
		this.aConsommer = aConsommer;
	}

	public char prendre()
	{
		char ret = ' ';
		if(p != null)
		{
			ret = p.prendre();
			i++;
		}
		return ret;
	}

	public boolean isFini() {
		return i >= aConsommer;
	}
	
}
