package modele.technique;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import modele.metier.SaveConnexion;

public class Serialiseur {

	public Serialiseur() {
		
	}
	
	public void serialiser(SaveConnexion connexion) {
		FileOutputStream fos = null;
		//FileInputStream fis = null;
		ObjectOutputStream oos = null;
		File f = new File("connexions.txt 																															");
		try {
			fos = new FileOutputStream(f);
			//fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(connexion);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
