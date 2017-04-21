package modele.technique;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import controleur.Manager;
import modele.metier.Attribut;
import modele.metier.Classe;
import modele.metier.Constructeur;
import modele.metier.Methode;
import modele.metier.Parametre;


public class Analyseur {
	private Class<?> maClasseT;
	private EditLoader<?> maClasse;
	
	public <T> Analyseur() {
		super();
		maClasse = new EditLoader<T>();
	}
	
	public <T> void analyser(String fileName, String path) {
		
		try {
	
			maClasseT = maClasse.loadEdiClass(path, fileName);
					
			//Instance d'un objet Classe
			Classe classe = new Classe(path, fileName);

			//Recuperation des attributs
			Field[] mesAttributs = maClasseT.getDeclaredFields();
			for (Field att : mesAttributs) {
				String attributName = att.getName();
				String attributType = att.getType().getSimpleName();
				int attributVisibility = att.getModifiers();	
				Attribut attribut = new Attribut(attributName, attributType, attributVisibility);
				classe.addAttribut(attribut);
			}
			
			//Recuperation des methodes
			Method[] mesMethodes = maClasseT.getDeclaredMethods();
			for (Method meth : mesMethodes) {
				String methodeName = meth.getName();
				String methodeReturnType = meth.getReturnType().getName();
				int methodeVisibility = meth.getModifiers();
				
				//Instance d'un objet methode
				Methode methode = new Methode(methodeName, methodeReturnType, methodeVisibility);
				
				//Recuperation des paramètre par methode
				Parameter[] parametres = meth.getParameters();
				
				for (Parameter param : parametres) {
					String parameterName = param.getName();
					String parameterType = param.getType().getSimpleName();
					
					Parametre parametre = new Parametre(parameterName, parameterType);
					methode.addParameter(parametre);
					classe.addMethode(methode);
				}
			}
			
			//Recuperation des constructeur
			Constructor[] mesConstructeurs = maClasseT.getConstructors();
			for (Constructor constr : mesConstructeurs) {
				String constructeurName = constr.getName();
				int constructeurVisibility = constr.getModifiers();
				
				//Instance d'un objet constructeur
				Constructeur constructeur = new Constructeur(constructeurName, constructeurVisibility);
				
				//Recuperation des paramètre par constructeur
				Parameter[] parametres = constr.getParameters();
				
				for (Parameter param : parametres) {
					String parameterName = param.getName();
					String parameterType = param.getType().getSimpleName();
					
					Parametre parametre = new Parametre(parameterName, parameterType);
					constructeur.addParameter(parametre);
					classe.addConstructeur(constructeur);
				}
			}

			//Stockage de la classe dans le tableau de Classe du Manager pour pouvoir afficher dans l'arbre plustard
			Manager.getInstance().addMesClasses(classe);
			//System.out.println("Stockage ok");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Pas trouvé la classe "+fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
