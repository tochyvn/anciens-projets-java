package coursjdbc;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class MonTableau extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonTableau() {
		
	}

	public MonTableau(TableModel dm) {
		super(dm);	
	}
	
	public MonTableau(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
	}

	public void setModel(TableModel tm) {
		this.setModel(tm);
	}

}
