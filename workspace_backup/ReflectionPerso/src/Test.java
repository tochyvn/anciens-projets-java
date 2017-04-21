import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;


public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		/**
		 * DEUX FAÇON DE RECUPERER UN OBJET CLASSE SOIT PAR:
		 * 1- SOIT PAR LE NOM DE LA CLASSE ET ON APPLIQUE .CLASS
		 * 2- SOIT PAR UN OBJET DE LA CLASSE ET ON APPLIQUE .GETCLASS()
		 */
		Class c = String.class;
		Class c2 = new String().getClass();
		Class m = Method.class;
		System.out.println("La superclasse de la classe "+m.getSimpleName()+" est : "+m.getSuperclass());
		Class constr = Constructor.class;
		System.out.println("La superclasse de la classe "+constr.getSimpleName()+" est : "+constr.getSuperclass().getSimpleName());
		/*
		System.out.println("La superclasse de la classe \""+String.class.getName()+"\" est : "+String.class.getSuperclass());
		System.out.println("La superclasse de la classe "+String.class.getSimpleName()+" est : "+String.class.getSuperclass().getSimpleName());
		
		
		//TROUVER LA LISTE DES INTERFACES IMPLEMENTÉES PAR LA CLASSE 
		Class[] faces = c.getInterfaces();
		System.out.println("Il y a "+faces.length+" interfaces implémentées");
		for (int i=0; i < faces.length; i++)
			System.out.println(faces[i]);*/
			
		/*
		//LISTE DES METHODES DE C2
		Method[] mesMethods = c2.getMethods();
		System.out.println("Cette classe a : "+mesMethods.length+" methodes");
		for(int i=0; i < mesMethods.length; i++) {
			System.out.println(mesMethods[i]);
			
			Class[] p = mesMethods[i].getParameterTypes();
			String modif = mesMethods[i].getReturnType().getName();
			System.out.println(modif);
		*/
			/*System.out.println("Les paramètres de la methode :");
		    for(int j = 0; j < p.length; j++)
		      System.out.println(p[j].getName());

		    System.out.println("----------------------------------\n");*/
		}
		
		/*
		//LISTE DES CHAMPS
		Field[] f = c2.getDeclaredFields();
		System.out.println("Cette classe a : "+f.length+" variables");
		for(int i=0; i < f.length; i++) {
			System.out.println(f[i]);
		}
		
		
		Constructor[] constructeurs = c.getConstructors();
		System.out.println("Cette classe a : "+constructeurs.length+" Constructeurs");
		for(int i=0; i < constructeurs.length; i++) {
			System.out.println(constructeurs[i]);
			
			System.out.println("Listes des classes des paramètre du constructeur");
			Class[] parametres = constructeurs[i].getParameterTypes();
			
			for( int j = 0; j<parametres.length; j++)
				System.out.println(parametres[j].getName());
		}
		*/
		
	}


