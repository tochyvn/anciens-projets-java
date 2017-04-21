package Exception1;

public class TestEntNat {

	public static void main(String[] args) {
		
		try {
			EntNat n1 = new EntNat(12);
			System.out.println("n1 = "+n1.getN());
			EntNat n2 = new EntNat(-20);
			System.out.println("n2 = "+n2.getN());
		} catch(ErrConst e) {
			System.out.println("******************ERREUR DE CONSTRUCTION : avec la valeur: "+e.getErreur()+" negative ***************************");
			System.exit(-1);
		}

	}

}
