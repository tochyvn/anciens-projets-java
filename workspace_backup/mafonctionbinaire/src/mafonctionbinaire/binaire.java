package mafonctionbinaire;

import java.util.Scanner;

public class binaire {


	public static void main(String[] args) {
		
		int nombre, r, base, temp;
		String bin = "";
		Scanner sc;
		
		//nombre = 16;
		//base = 4;
		
		sc = new Scanner(System.in);
		
		System.out.println("Entrez un nombre en base 10");
		nombre = sc.nextInt();
		temp = nombre;
		
		System.out.println("Entrer la base de conversion");
		base = sc.nextInt();
		
		sc.close();
		
		while (nombre != 0) {
			r = nombre % base;
			bin = r + bin;
			nombre = (int)(nombre/base);
		}
		
		System.out.print("Le nombre "+temp+" en base "+base+" vaut "+bin);
		
	}

}
