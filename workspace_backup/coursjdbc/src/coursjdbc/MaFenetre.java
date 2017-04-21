package coursjdbc;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MaFenetre extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private MaTable table;

	public MaFenetre() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);;
		this.setLocationRelativeTo(null);
		this.setBounds(20, 20, 600, 600);
		this.setTitle("JTable");
		table = new MaTable();
		table.recuperer("SELECT * FROM PROF");
		//DefaultTableModel model = new DefaultTableModel(table.getContenu(), table.getLesTitres());
		//tableau = new MonTableau(model);
		/*
		Object[][] data = {
				{"TOCHAP", "28 ans", "1.80 m"}, 
				{"ZLATAN", "28 ans", "1.80 m"}, 
				{"RUSKOV", "24 ans", "1.90 m"}, 
				{"YVANOV", "32 ans", "1.85 m"}
				};
		String title[] = {"Pseudo", "Age", "Taille"};
		*/
		
		Vector<Vector<String>> data = table.getContenu();
		Vector<String> title = table.getLesTitres();
		
		tableau = new JTable(data, title);
		this.add(new JScrollPane(tableau));
		//this.setVisible(true);
	}
	

}
