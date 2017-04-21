/**
 * 
 */
package vue.composant;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import modele.metier.EtudiantOld;

/**
 * @author silnti
 *
 */
public class EtudiantDefaultModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2898556015580746567L;
	
	/**
	 * Tableau contenant les titres des colonnes;
	 */
	private Vector<String> titles;
	/**
	 * Tableau contenant les données
	 */
	private Vector<Vector<String>> data;

	/**
	 * 
	 */
	public EtudiantDefaultModel() {
		super();
	}

	/**
	 * @param data
	 * @param columnNames
	 */
	public EtudiantDefaultModel(Vector<Vector<String>> data, Vector<String> columnNames) {
		super(data, columnNames);
		titles = columnNames;
		this.data = data;
	}


	@Override
	public int getColumnCount() {
		return titles.size();
	}

	@Override
	public String getColumnName(int column) {
		return titles.get(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return data.get(row).get(column);
	}

	@Override
	public int getRowCount() {
		return data.size();
	}
	
	public void setData(Vector<EtudiantOld> etudiants) {
		data = new Vector<>();
		data.add(titles);
		for (EtudiantOld etudiant : etudiants) {
			Vector<String> e = new Vector<String>();
			e.add(etudiant.getReference());
			e.add(etudiant.getNom());
			e.add(etudiant.getPrenom());
			e.add(etudiant.getSpecialite());
			data.add(e);
		}
		fireTableChanged(null);
	}

}
