package vue.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import vue.composant.MonCombobox;
import vue.composant.MonComboboxModel;
import controleur.Manager;

/**
 * Classe permettant le remplissage de la zone de colonne lorsque une table est selectionnée
 * @author TOCHAP
 *@version 1.0.1
 */
public class ItemSelectTable implements ActionListener {
	private MonCombobox combo;
	private MonCombobox combo1;
	/**
	 * Constructeur de la classe
	 * @param combo represente la zone contenant la liste des tables
	 * @param combo1 represente la zone contenant la liste des colonnes
	 */
	public ItemSelectTable(MonCombobox combo, MonCombobox combo1) {
		super();
		this.combo = combo;
		this.combo1 = combo1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int index = combo1.getSelectedIndex();
		//System.out.println("%%%%%%%%%%%%%%%%%"+item+"%%%%%%%%%%%%%%%%");
		if (Manager.conn == null) {
			System.out.println("************Vous n'etes pas connecté******************");
		}else {
			//Si une table est selectionnée
			if (!(index <= 0)) {
				String item = combo1.getSelectedItem().toString();
				Vector<String> colonnes = Manager.getInstance().getColonnes(item);
				colonnes.add(0, "Colonnes");
				colonnes.add(1, "*");
				System.out.println("tochap");
				for (String string : colonnes) {
					System.out.println("££££££££££££££"+string+"££££££££££££££");
				}
				MonComboboxModel model = new MonComboboxModel(colonnes);
				combo.setModel(model);
				
			} else {
				combo.removeAllItems();
				combo.addItem("Colonnes");
			}
		}
	}

}
