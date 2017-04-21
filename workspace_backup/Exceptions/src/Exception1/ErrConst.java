package Exception1;

public class ErrConst extends Exception{
	private int valeur;
	
	public ErrConst(int entier) {
		this.valeur = entier;
	}
	//Methode permettant de recuperer la valeur provoquant l'exception
	public int getErreur() {
		return valeur;
	}

}
