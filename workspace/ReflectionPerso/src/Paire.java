import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Paire {
	String valeur1, valeur2;

	public Paire() {
		this.valeur1 = null;
		this.valeur2 = null;
		System.out.println("Instanciation");
	}
	
	public Paire(String val1, String val2) {
		this.valeur1 = val1;
		this.valeur2 = val2;
		System.out.println("Instanciation avec paramètres");
	}
	
	public String toString() {
		return "Je suis un objet qui a pour valeur : " + this.valeur1 +  " - " + this.valeur2;
	}
	

	public String getValeur1() {
		return valeur1;
	}

	public void setValeur1(String valeur1) {
		this.valeur1 = valeur1;
	}

	public String getValeur2() {
		return valeur2;
	}

	public void setValeur2(String valeur2) {
		this.valeur2 = valeur2;
	}

	public static void main(String[] args) {
		
		String nom = Paire.class.getName();
		try {
			//On cree un objet classe ayant pour nom Paire
			Class cl = Class.forName(nom);
			
			//Nouvelle instance de la classe paire
			Object o = cl.newInstance();
			
			//On crée les paramètres du constructeur
			Class[] types = new Class[]{String.class, String.class};
			
			//On recupere le constructeur avec les deux paramètres
			Constructor ct = cl.getConstructor(types);
			
			//On instancie l'objet avec le constructeur surchargé
			Object o2 = ct.newInstance(new String[]{"valeur 1 ", "valeur 2"});
			
			//On va chercher la methode toString
			Method m = cl.getMethod("toString", null);
			
			//La méthode invoke exécute la méthode sur l'objet passé en paramètre
		    //Pas de paramètre, donc null en deuxième paramètre de la méthode invoke !
			System.out.println("----------------------------------------");
		    System.out.println("Méthode " + m.getName() + " sur o2: " +m.invoke(o2, null));
		    System.out.println("Méthode " + m.getName() + " sur o: " +m.invoke(o, null));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
