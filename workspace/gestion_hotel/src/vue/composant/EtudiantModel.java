/**
 * 
 */
package vue.composant;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.metier.Etudiant;

/**
 * @author silnti
 *
 */
public class EtudiantModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -454635287975735317L;
	/**
	 * Tableau contenant les titres des colonnes;
	 */
	private final List<String> titles;
	/**
	 * Tableau contenant les données
	 */
	private List<List<String>> data;

	/**
	 * 
	 */
	public EtudiantModel() {
		super();
		titles = new ArrayList<>();
		titles.add("REFERENCE");
		titles.add("NOM");
		titles.add("PRENOM");
		titles.add("SPECIALITE");
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return data.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return titles.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return titles.get(column);
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public void setData(List<Etudiant> etudiants) {
		data = new ArrayList<>();
		for (Etudiant etudiant : etudiants) {
			ArrayList<String> e = new ArrayList<String>();
			e.add(etudiant.getReference());
			e.add(etudiant.getNom());
			e.add(etudiant.getPrenom());
			e.add(etudiant.getSpecialite());
			data.add(e);
		}
		fireTableChanged(null);
	}
	
	

}
