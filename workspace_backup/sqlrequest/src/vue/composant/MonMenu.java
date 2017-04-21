package vue.composant;

import javax.swing.JMenu;

import vue.action.AuthentificationListener;
import vue.action.ExecuteListener;
import vue.action.ExporterListener;

public class MonMenu extends JMenu {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonItem connexion;
	private MonItem executer;
	private MonItem exporter;
	private MonItem fermer;

	public MonMenu(String string, AuthentificationListener connexion2) {
		super();
	}

	public MonMenu(String s, AuthentificationListener connexion1, ExecuteListener execution, ExporterListener export) {
		super(s);
		connexion = new MonItem("Connexion");
		connexion.addActionListener(connexion1);
		exporter = new MonItem("Exporter");
		exporter.addActionListener(export);
		executer = new MonItem("Executer");
		executer.addActionListener(execution);
		fermer = new MonItem("Fermer");
		this.add(connexion);
		this.add(executer);
		this.add(exporter);
		this.add(fermer);
	}

}
