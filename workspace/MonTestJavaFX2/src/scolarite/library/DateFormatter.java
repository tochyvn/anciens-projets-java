package scolarite.library;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatter {

	public DateFormatter() {
		
	}
	
	public static String getDateFormatted(Date date, String format) {
		
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat(format);
		//System.out.println(formater.format(date));
		return formater.format(date);
	}
	
	/**
	 * Converti une chaine de caractère au format date "dd/MM/yyyy" correct en Date pour l'insertion dans mysql
	 * @param date
	 * @return
	 */
	public static Date convertStringToDate(String date) {
		
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		try {
			today = formater.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Format date incorrect");
			e.printStackTrace();
		}
		return today;
	}

}
