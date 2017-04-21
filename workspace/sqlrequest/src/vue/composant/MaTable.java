package vue.composant;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class MaTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaTable() {
		super();
		this.setFont(new Font("Arial bold", Font.BOLD, 16));
	}

	public MaTable(TableModel dm) {
		super(dm);
		
	}

	public MaTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		// TODO Auto-generated constructor stub
	}

	public MaTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public MaTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		// TODO Auto-generated constructor stub
	}

	public MaTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		// TODO Auto-generated constructor stub
	}

	public MaTable(Vector<Vector<String>> rowData, Vector<String> columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}
	
	

}
