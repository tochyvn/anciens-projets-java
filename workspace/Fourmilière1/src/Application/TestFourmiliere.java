package Application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import Fourmilière.*;
import Message.*;
/**
 * 
 * @author silnti
 *
 */
public class TestFourmiliere {
	 public static int i;
	 private static File file = new File("trace.txt");
	 
	public static void main(String[] args) {
		
		//permet de supprimer le fichier 
		 while(file.exists()){
				
			 file.delete();
			 
			}
		 
		Fourmiliere f = new Fourmiliere();
		
		
	 for(i = 1; i <= f.getDureeVie(); i++) {  
	
		affiche("\n-------------------------- <<<< Debut d'un nouveau cycle (CYCLE N°"+i+") >>>> ----------------------\n");
		//nouveau temps pour tout le monde
		f.nouveauCycle();
		
		affiche("\n======================== Gestion des messages ===============================\n");
		while(!Messagerie.getInstance().estVide()) {
		
			Message m = Messagerie.getInstance().readMessage();
			m.action(f);
		}
		
			
		affiche("\n---------------------------- <<<< Fin du cycle >>>> -------------------------------\n");
		
	 }
	 affiche("\t\tBILAN DE LA FOURMILIÈRE\n");
	 affiche("La Naissance a fait naitre au total : "+(Naissance.numOuv+Naissance.numSoi+Naissance.numSol)+" fourmis soient:");
	 affiche("\tOuvrières : "+Naissance.numOuv);
	 affiche("\tSoldats : "+Naissance.numSol);
	 affiche("\tSoigneurs : "+Naissance.numSoi);
	 
	 affiche("\nFourmi blessées ramenées à la fourmilière : "+f.getFourmisMortes().size());
	 for (int j = 0; j<f.getFourmisMortes().size(); j++)
		 affiche("\t"+f.getFourmisMortes().get(j).afficheInfoFourmi());
	 
	 affiche("\nFourmi blessées non ramenées à la fourmilière : "+f.getFourmisBlessees().size());
	 for (int j = 0; j<f.getFourmisBlessees().size(); j++)
	     affiche("\t"+f.getFourmisBlessees().get(j).afficheInfoFourmi());
	 
	 affiche("\nFourmi blessées en cours de recupération : "+f.getFourmisRecup().size());
	 for (int j = 0; j<f.getFourmisRecup().size(); j++)
	     affiche("\t"+f.getFourmisRecup().get(j).afficheInfoFourmi());
	 
	 affiche("\nFourmi vivantes : "+f.getFourmis().size());
	 for (int j = 0; j<f.getFourmis().size(); j++)
	     affiche("\t"+f.getFourmis().get(j).afficheInfoFourmi());
	 
	      
 } 
	/**
	 * Methode permettant d'ecrire dans le fichier trace.txt
	 * @param chaine permet d'entrer une chaîne en paramètre
	 */
	public static void affiche(String chaine) {
		
		PrintWriter pw;
		
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			pw.println(chaine);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//pour afficher dans la console
		System.out.println(chaine);
	}
	
	
}
