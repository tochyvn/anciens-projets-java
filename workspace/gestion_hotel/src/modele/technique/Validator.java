package modele.technique;

import java.util.regex.Pattern;

public class Validator {
	
	/**
	 * Pattern que doit respecter un numero de telephone en france
	 */
	public final static String REGEXP_PHONE = "^0[1-8]([-. ]?[0-9]{2}){4}$";
	/**
	 * Pattern que doit respecter une adresse email
	 */
	public final static String REGEXP_EMAIL = "^[a-z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$";
	
	
	/**
	 * 
	 * @param la valeur � tester
	 * @param regexp constante predefinie representant le format a respecter (email, telehone)
	 * @return retourne true si oui et false si non
	 */
	public static boolean regexp(String valeur, String regexp) {
		
		Pattern pattern = Pattern.compile(regexp);
		
		return pattern.matcher(valeur).matches();
	}
	
	/**
	 * Permet de savoir si une valeur est enti�re
	 * @param nombre nombre a tester
	 * @return retourne true si oui c'est un nombre sinon false
	 */
	public static boolean validateNombre(String nombre) {
		boolean bool = true;
		try {
			Double d = Double.valueOf(nombre);
		} catch (Exception e) {
			bool = false;
		}
		
		return bool;
	}
	/**
	 * Tester si une chaine est vide
	 * @param chaine la chaine à tester
	 * @return retourne true si elle est vide, sinon retourne false
	 */
	public static boolean isEmpty(String chaine) {
		boolean bool = true;
		if (!chaine.equals("")) {
			bool = false;
		}
		return bool;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Validator.regexp("lion.tochlion@yahoo.fr", Validator.REGEXP_EMAIL));
	}

}
