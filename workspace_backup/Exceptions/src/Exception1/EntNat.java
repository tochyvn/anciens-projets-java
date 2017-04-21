package Exception1;

public class EntNat {
	private int n;
	/**
	 * Constructeur 
	 * @param entier Correspont à l'entier naturel que l'on souhaite tester si (>=0 ou <0)
	 * @throws ErrConst permettant de signaler à la JVM qu'une erreur peut se produire
	 */
	public EntNat(int entier) throws ErrConst{
		
		if (entier<0) 
			throw new ErrConst(entier);
		this.n = entier;
		
	}
	//Methode retournant l'entier
	public int getN() {
		return n;
	}

}
