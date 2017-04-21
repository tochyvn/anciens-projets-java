package vue.composant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import vue.action.ActvateJointure;
import vue.action.AuthentificationListener;
import vue.action.ConfirmCloseListener;
import vue.action.ExecuteListener;
import vue.action.ExporterListener;
import vue.action.ItemSelectColonne;
import vue.action.ItemSelectTable;
import vue.action.RazListener;


public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonSplit diviseur;
	private MaBarreMenu barreMenu;
	private MonPanel panelPrincipal;
	private MaTable zoneResultat;
	private MonCombobox combobox1;
	private MonCombobox combobox2;
	private MonInput select;
	private MonInput from;
	private MonLabel lblSelect;
	private MonLabel lblFrom;
	private MonLabel lblTable;
	private MonLabel lblColonne;
	private MonLabel lblWhere;
	private JEditorPane jointure;
	private JTextField condition;
	private JCheckBox checkJoin;
	private JButton executer;
	private JButton exporter;
	private JButton raz;
	private JButton suppCol;

	public FenetrePrincipale() throws HeadlessException {
		
		super("Requeteur Universel");
		checkJoin = new JCheckBox("Generer les jointures automatiquement");
		checkJoin.setSelected(true);
		lblTable = new MonLabel("------Tables--------");
		lblColonne = new MonLabel("------Colonnes------");
		lblSelect = new MonLabel("select");
		lblFrom = new MonLabel("From");
		lblWhere = new MonLabel("Where");
		select = new MonInput();
		from = new MonInput();
		
		executer = new JButton("Executer");
		raz = new JButton("Raz");
		suppCol = new JButton("Supprimer");
		exporter = new JButton("Exporter");
		jointure = new JEditorPane();
		condition = new JTextField();
		jointure.setEditable(false);
		jointure.setSize(50, 50);
		combobox1 = new MonCombobox("Tables");
		combobox2 = new MonCombobox("Colonnes");
		diviseur = new MonSplit();
		panelPrincipal = new MonPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		panelPrincipal.setLayout(gbl_panel);
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPrincipal.setBackground(Color.LIGHT_GRAY);
		diviseur.add(panelPrincipal, 0);		
		
		//Listener pour le nettoyage des differentes zones
		RazListener effacer = new RazListener(select, from, jointure, condition, combobox1, combobox2);
		raz.addActionListener(effacer);
		
		//Listener de selection de colonnes
		ItemSelectColonne selectCol = new ItemSelectColonne(combobox1, combobox2, select, 
				from, jointure, checkJoin);
		combobox2.addActionListener(selectCol);
		
		//Listener pour l'authentification
		AuthentificationListener connexion = new AuthentificationListener(combobox1);
		
		//Listener de selection de table
		ItemSelectTable selectTable = new ItemSelectTable(combobox2, combobox1);
		combobox1.addActionListener(selectTable);
		
		//Listener de fermeture de la fenetre
		ConfirmCloseListener fl = new ConfirmCloseListener();
		this.addWindowListener(fl);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;

		gbc.gridx = 0; gbc.gridy = 0;  
		gbc.gridheight = 1; gbc.gridwidth = 1;  
		gbc.insets = new Insets(20, 10, 0, 0);
		panelPrincipal.add(lblTable, gbc);
		
		gbc.gridx = 1; gbc.gridwidth = 2;
		gbc.gridy = 0;	gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridheight = 1; 
		gbc.insets = new Insets(20, 15, 0, 0);
		panelPrincipal.add(combobox1, gbc);
		
		gbc.gridx = 7;  gbc.gridheight = 1; gbc.fill = GridBagConstraints.NONE;
		gbc.gridy = 0;  gbc.gridwidth = 1; 
		gbc.insets = new Insets(20, 0, 0, 10);
		panelPrincipal.add(lblColonne, gbc);
		
		gbc.gridx = 8;  gbc.gridheight = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 0;  gbc.gridwidth = GridBagConstraints.REMAINDER; 
		gbc.insets = new Insets(20, 0, 0, 0);
		panelPrincipal.add(combobox2, gbc);
		
		gbc.gridx = 0;  gbc.gridheight = 1; gbc.fill = GridBagConstraints.NONE;
		gbc.gridy = 1;  gbc.gridwidth = 1; 
		gbc.anchor = GridBagConstraints.WEST;  
		gbc.insets = new Insets(20, 10, 0, 0);
		panelPrincipal.add(lblSelect, gbc);
		
		gbc.gridx = 1; 
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 20, 0, 10);	//gbc.weighty = 1.5;
		panelPrincipal.add(select, gbc);
		
		gbc.gridx = 0; gbc.gridheight = 1;
		gbc.gridy = 3; gbc.gridwidth = 1;
		gbc.insets = new Insets(20, 10, 0, 0);
		panelPrincipal.add(lblFrom, gbc);
		
		gbc.gridx = 1; 
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 20, 0, 10);
		panelPrincipal.add(from, gbc);
		
		gbc.gridx = 1; gbc.gridy = 5;   
		gbc.gridheight = 1;  gbc.gridwidth = 1; 
		gbc.insets = new Insets(20, 20, 0, 0);
		gbc.anchor = GridBagConstraints.WEST;
		panelPrincipal.add(lblWhere, gbc);
		
		 
		gbc.gridx = 2;   gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		panelPrincipal.add(checkJoin, gbc);
		
		gbc.gridx = 0; gbc.gridy = 6; gbc.ipady = 50;
		gbc.gridwidth = 1; gbc.gridheight = 1;  gbc.insets = new Insets(20, 10, 0, 0);
		panelPrincipal.add(new MonLabel("Jointure automatique"), gbc);
		
		gbc.gridx = 1; gbc.ipady = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER; 
		gbc.gridheight = 6;  
		gbc.insets = new Insets(0, 10, 0, 10);
		gbc.fill = GridBagConstraints.BOTH;
		JScrollPane js = new JScrollPane(jointure);
		js.setPreferredSize(new Dimension(50, 50));
		panelPrincipal.add(js, gbc);
		
		gbc.gridx = 0; gbc.gridy = 10;  gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = 1; gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panelPrincipal.add(new MonLabel("Conditions personnalisées"), gbc);
		
		gbc.gridx = 1; gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 3;  
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panelPrincipal.add(condition, gbc);
		
		gbc.gridx = 2; gbc.gridwidth = 1;
		gbc.gridy = 13; gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 20, 10);
		gbc.fill = GridBagConstraints.NONE;
		panelPrincipal.add(executer, gbc);
		
		gbc.gridx = 4;
		panelPrincipal.add(exporter, gbc);
		
		gbc.gridx = 6;  
		panelPrincipal.add(raz, gbc);
		
		gbc.gridx = 8; gbc.gridwidth = GridBagConstraints.REMAINDER; 
		panelPrincipal.add(suppCol, gbc);
		
		
		zoneResultat = new MaTable();
		zoneResultat.setBackground(Color.BLACK);
		zoneResultat.setForeground(Color.WHITE);
		
		//Listener de generation de jointure auto
		ActvateJointure jointauto = new ActvateJointure(jointure, checkJoin);
		checkJoin.addActionListener(jointauto);
		
		//Listener d'execution d'une requete 
		ExecuteListener execution = new ExecuteListener(zoneResultat, select, from, jointure, condition);
		executer.addActionListener(execution);
		
		diviseur.add(new JScrollPane(zoneResultat), 1);
		
		//Listener d'exportation sous forme de Excel ou CSV
		ExporterListener export = new ExporterListener(zoneResultat);
		exporter.addActionListener(export);
		
		barreMenu = new MaBarreMenu(connexion, execution, export);
		
		//this.setMinimumSize(new Dimension(800, 600));
		this.setBounds(10, 20, 1000, 700);
		this.setJMenuBar(barreMenu);
		this.add(diviseur);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
