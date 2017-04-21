package modele.technique;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controleur.Manager;
import vue.composant.MonFileChooser;


public class GestionFile {
	
	ArrayList<File> openFiles;

	public GestionFile() {
		openFiles = new ArrayList<File>();
	}
	/**
	 * Methode permettant l'ouverture et lecture du fichier
	 * @return retourne le contenu du fichier ouvert
	 */
	public String[] readFile() {
		
		File file = null;
		String[] contenu = new String[2];
		MonFileChooser ouvrir = new MonFileChooser();
		int resultat = ouvrir.showOpenDialog(null);
		if (resultat == MonFileChooser.APPROVE_OPTION) {
			file = ouvrir.getSelectedFile();
			contenu[0]=file.getName();
		
		
			try {
				String fileContent = null;
				contenu[1] = "";
				BufferedReader br = new BufferedReader(new FileReader(file)); 
				while((fileContent = br.readLine()) != null) {
					if (fileContent != null)
					contenu[1] += fileContent+"\n";
			}
			  br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			openFiles.add(file);
		}
		return contenu;	
	}
	
	public boolean saveFile(int index, String text) {
		boolean bool = false; 
		System.out.println("Sauvegarde en cours....");
		File file = this.openFiles.get(index);
		if (file == null) {
			System.out.println("file don't exist!!!!!");
			MonFileChooser saveDialog = new MonFileChooser();
			int reponse = saveDialog.showSaveDialog(null);
			if (reponse == MonFileChooser.APPROVE_OPTION) {
				file = saveDialog.getSelectedFile();
			}		
		}
		
		//Ecriture dans le fichier
		try {
			System.out.println("Ecriture en cours....");
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Nouveau contenu -----"+text);
			bw.write(text);
			System.out.println(text);
			bw.close();
			bool = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			bool = false;
			e.printStackTrace();
			
		}
		
		if (!isInArrayOpenFiles(file)) {
			System.out.println("ajout du fichier en cours...");
			openFiles.add(file);
		}
		
		return bool;
	}
	
	public boolean isInArrayOpenFiles(File f) {
		int index = openFiles.indexOf(f);
		
		return (index != -1);
		
	}
	public void saveAsFile(int index, String text) {
		
		//System.out.println("Sauvegarde en cours....");
		//File file = this.openFiles.get(index);
		
			File file = null;
			MonFileChooser saveDialog = new MonFileChooser();
			int reponse = saveDialog.showSaveDialog(null);
			if (reponse == MonFileChooser.APPROVE_OPTION) {
				file = saveDialog.getSelectedFile();
				
				//Ecriture dans le fichier
				try {
					System.out.println("Ecriture en cours....");
					FileWriter fw = new FileWriter(file, false);
					BufferedWriter bw = new BufferedWriter(fw);
					System.out.println("Nouveau contenu -----"+text);
					bw.write(text);
					System.out.println(text);
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (!isInArrayOpenFiles(file)) {
					System.out.println("ajout du fichier en cours...");
					openFiles.add(file);
				}
				
			}		
		
	}
	public void compile(int index) {
		
		File file = openFiles.get(index);
		Process process;
		try {
			process = Runtime.getRuntime().exec("javac" + " " + file);
			InputStream error=process.getErrorStream();
			BufferedReader buffError=new BufferedReader(new InputStreamReader(error));
			
			if(buffError.readLine()!=null){
				//Manager.getInstance().getErrors(buffError.readLine());
			}else{
				//Manager.getInstance().getReeors("Compiled succefuly ...!");
				//System.out.println("Compilation reussie");
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch bloc
			e1.printStackTrace();
			//System.out.println("Beurk");
		}
		
	}
	/**
	 * Methode permettant de recuperer le nom de la classe correspondant au fichier .java
	 * @param index index du fichier dans le tableau de fichier ouvert
	 * @return retourne le nom de la classe
	 */
	public String getFileName(int index) {
		File f = openFiles.get(index);
		String nom = f.getName().substring(0,f.getName().length()-5);
		return nom;
	}
	/**
	 * Methode permettant de recuperer le chemin du repertoire contenant le fichier
	 * @param index index du fichier dans le tableau de fichier ouvert
	 * @return le chemin du repertoire 
	 */
	public String getFileSource(int index) {
		File f = openFiles.get(index); 
		String path = f.getAbsolutePath();
		int last = path.lastIndexOf('/');
		String pathSimple = path.substring(0, last+1);
		
		return pathSimple;	
	}

}
