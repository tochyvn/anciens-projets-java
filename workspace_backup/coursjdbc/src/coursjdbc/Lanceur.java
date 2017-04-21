package coursjdbc;

public class Lanceur {

	public Lanceur() {
		
	}
	
public static void main(String[] args) {
		MaFenetre fenetre = null;
		fenetre = new MaFenetre();
		fenetre.setVisible(true);
	
	MaTable table = new MaTable();
	table.recuperer("SELECT * FROM ELEVE");
	}

}
