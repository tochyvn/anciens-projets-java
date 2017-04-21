import java.util.HashMap;
import java.util.TreeSet;


public class RepertoireTelephonique {

	private HashMap<Personne, TreeSet<String>> telephones;
	
	public RepertoireTelephonique() {
		telephones = new HashMap<Personne, TreeSet<String>>();
	}
	
	public void addNum(Personne p, String numero) {
		TreeSet<String> ts = telephones.get(p);
		//Si la personne ne possede pas encore de numero On cree l'ensemble qui stockera ses numero
		if (ts == null) {
			ts = new TreeSet<String>();
			telephones.put(p, ts);
		}
		ts.add(numero);
	}
	
	public void deleteNumber(Personne p, String numero) {
		TreeSet<String> ts = telephones.get(p);
		//Si la personne possède des numero
		if (ts != null) {
			ts.remove(numero);
			//Si la personne n'a aucun numéro
			if (ts.isEmpty())
				telephones.remove(p);
		}
	}

}
