package vue.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;
import vue.composant.MaTable;

/**
 * Classe permettant d'exporter le resultat d'une requete sous format excel ou csv
 * @author TOCHAP
 *@version 1.0.1
 */
public class ExporterListener implements ActionListener {

	private MaTable maTable;
	
	/**
	 * 
	 * @param maTable
	 */
	public ExporterListener(MaTable maTable) {
		this.maTable = maTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		File file = null;
		JFileChooser jfile = new JFileChooser("/Users/silnti/Documents/workspace/sqlrequest/Exporter");
		int statut = jfile.showSaveDialog(null);
		if (statut == JFileChooser.APPROVE_OPTION) {
			file = new File (jfile.getSelectedFile().getAbsolutePath());
			
			TableModel model = maTable.getModel();
			try {
				FileWriter ecriture = new FileWriter(file);
				//recuperation des entetes de colonnes du resultat et ecriture dans le fichier
				for(int i=0; i<model.getColumnCount(); i++) {
					ecriture.write(model.getColumnName(i)+"\t");
				}
				ecriture.write("\n");
				//recuperation du contenu et ecriture
				for(int i=0; i<model.getRowCount(); i++) {
					for(int j=0; j<model.getColumnCount(); j++) {
						ecriture.write(model.getValueAt(i, j).toString()+"\t");
					}
					ecriture.write("\n");
				}
				ecriture.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}		
		
	}

}
