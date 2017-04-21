package controleur;

import java.util.ArrayList;

import modele.metier.Classe;
import modele.technique.Analyseur;
import modele.technique.EditLoader;
import modele.technique.GestionFile;

public class Manager {
	
	private static Manager instance = new Manager();
	private GestionFile gestionnaire;
	private ArrayList<Classe> mesClasses;
	private Analyseur analyseur;

	private Manager() {
		mesClasses = new ArrayList<Classe>();
		gestionnaire = new GestionFile();
		analyseur = new Analyseur(); 
		
	}

	public static Manager getInstance() {
		return instance;	
	}
	
	public String[] openFile() {
		
		String[] contenu = gestionnaire.readFile();
			return contenu;
		
		/*
		String nom = f.getName().substring(0,f.getName().length()-5);
		System.out.println(content);
		System.out.println(nom);
		*/
		
	}

	public boolean save(int index, String text) {
		boolean save = gestionnaire.saveFile(index, text);
		return save;
	}

	public void saveAs(int index, String text) {
		gestionnaire.saveAsFile(index, text);	
	}
	/**
	 * Methode permettant de compiler une classe
	 * @param index index du fichier dans le tableau des fichiers ouverts
	 */
	public void compile(int index) {
		gestionnaire.compile(index);
	}
	/**
	 * Methode permettant de deleguer l'analyse a la classe Analyse
	 * @param index represente l'index du fichier dans le tableau des fichiers ouverts
	 */
	public void analyse(int index) {
		String fileName = gestionnaire.getFileName(index);
		String path = gestionnaire.getFileSource(index);
		analyseur.analyser(fileName, path);
		
	}
	
	public ArrayList<Classe> getMesClasses() {
		return mesClasses;
	}

	public void addMesClasses(Classe classe) {
		this.mesClasses.add(classe);
	}

	public Classe getClasse(int index) {
		return mesClasses.get(index);
	}
	/*
	public String getErrors() {
		return null;
		
		
	}*/
	
}
