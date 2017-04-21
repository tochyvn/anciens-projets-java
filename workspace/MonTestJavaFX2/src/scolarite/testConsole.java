package scolarite;

import java.util.Date;

import scolarite.library.DateFormatter;
import scolarite.model.beans.Eleve;
import scolarite.model.dao.Connexion;
import scolarite.model.dao.EleveDAO;

public class testConsole {

	public testConsole() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		EleveDAO eleveDAO = new EleveDAO(Connexion.getConnexion());
		Date date = new Date();
		Eleve eleve = new Eleve("tochap", "lion", DateFormatter.convertStringToDate("10/04/2016"));
		int status = eleveDAO.create(eleve);
		System.out.println(status);
		System.out.println(date);
		*/
		System.out.println(new Date("10/04/2016"));
		
		
	}

}
