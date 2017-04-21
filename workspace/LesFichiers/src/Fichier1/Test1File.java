package Fichier1;

import java.io.File;
import java.io.IOException;

public class Test1File {
	//private File file;

	public Test1File() {
		
	}

	public static void main(String[] args) {
		
		Test1File f = new Test1File();
		
		f.afficheFile("/Applications/MAMP/htdocs/schema.xml");
	}
	
	public void afficheFile(String path) {
		File file = new File(path);
		//On met le contenu du tableau dans un tableau de chaine
		String[] contenuFile = file.list();
		//On parcours le tableau pour afficher les fichiers et repertoire contenu dans ce file
			/*for(String s:contenuFile) {
				//ON recupere l'element
				File f2 = new File(path+s);
				//si cet element est un repertoire
				if (f2.isDirectory()) {
					System.out.println("REPERTOIRE-----> "+s+" Longueur "+f2.length());
					//afficheFile(path+s);
				}
				//si c'est un fichier
				else
					System.out.println("Fichier-----> "+s+" Longueur "+f2.length());
	
			}*/
	System.out.println("---------------------------------------------------------");
	System.out.println(file.getAbsolutePath());
	System.out.println(file.getName());
		
		System.out.println(file.getName().length());
		
		System.out.println(file.getName().substring(0,file.getName().length()-4));
	
	}
}


