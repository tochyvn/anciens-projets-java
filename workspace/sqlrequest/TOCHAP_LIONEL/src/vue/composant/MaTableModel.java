package vue.composant;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MaTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaTableModel() {
		super();
	}

	public MaTableModel(Vector<Vector<String>> contenu, Vector<String> columnNames) {
		super(contenu, columnNames);
	}
	
}
