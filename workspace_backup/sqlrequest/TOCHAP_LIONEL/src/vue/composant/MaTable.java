package vue.composant;

import java.awt.Font;

import javax.swing.JTable;
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

}
