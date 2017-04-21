package edi;

public class Manager {
	private static Manager moi = new Manager();
	private StringBuffer modele;
	private Manager() {
		modele = new StringBuffer("initialisation");
	}
	public static Manager getInstance()
	{
		return moi;
	}
	
	public String getModele()
	{
		return modele.toString();
	}
	
	public void ajouteModele(String s)
	{
		modele.append(s);
	}

}
