package prodcons.modele.metier;

import prodcons.modele.technique.Panier;

public class Producteur {

	private String ap;
	private Panier p;
	private int pos;
	public Producteur() {
		ap = null;
		p = null;
		pos = 0;
	}
	public void setPanier(Panier p)
	{
		this.p = p;
	}
	public void poser()
	{
		if (p != null)
		{
			p.poser(ap.charAt(pos));
			pos++;
		}
	}
	public boolean isFini() {
		return pos >= ap.length();
	}
	public String getAp() {
		return ap;
	}
	public void setAp(String ap) {
		this.ap = ap;
	}
}
