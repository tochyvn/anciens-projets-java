package vue.composant;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import vue.action.AnnulerListener;
import vue.action.ConnexionListener;

public class FenetreConnexion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton valider;
	private JButton abandonner;
	private JTextField user;
	private JTextField passwd;
	private MonLabel lblUser;
	private MonLabel lblPasswd;
	private MonPanel container;
	private MonLabel lblDatabase;
	private MonCombobox database;
	private MonLabel lblDriver;
	private MonCombobox driver;

	public FenetreConnexion(MonCombobox combo) throws HeadlessException {
		super("Identification");
		
		this.setBounds(60, 60, 580, 250);
		lblUser = new MonLabel("Utilisateur");
		lblPasswd = new MonLabel("Mot de passe");
		user = new JTextField();
		passwd = new JTextField();
		valider = new JButton("Connecter");
		abandonner = new JButton("Annuler");
		container = new MonPanel();
		lblDriver = new MonLabel("Type de driver");
		driver = new MonCombobox(Constante.DRIVERS);
		lblDatabase = new MonLabel("Base de données");
		database = new MonCombobox(Constante.DATABASES);
		
		ConnexionListener connexion = new ConnexionListener(combo, driver, database, user, passwd, this);
		valider.addMouseListener(connexion);
		
		AnnulerListener annuler = new AnnulerListener(this);
		abandonner.addMouseListener(annuler);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		container.setLayout(gbl_panel);
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		container.setBackground(Color.LIGHT_GRAY);
		
		GridBagConstraints gbc = new GridBagConstraints();
		//gbc.anchor = GridBagConstraints.CENTER;
	
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.insets = new Insets(10, 2, 0, 0);
		gbc.gridwidth = 1; 
		container.add(lblDriver, gbc);
		
		gbc.gridx = 1; gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		container.add(driver, gbc);
		
		gbc.gridx = 3;  gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		container.add(lblDatabase, gbc);
		
		gbc.gridx = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		container.add(database, gbc); 
		
		gbc.gridx = 0;  gbc.gridwidth = 1;
		gbc.gridy = 1;  gbc.gridheight = 1; 
		container.add(lblUser, gbc);
		
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		container.add(user, gbc);
		
		gbc.gridx = 0;  gbc.gridwidth = 1;
		gbc.gridy = 2;  
		container.add(lblPasswd, gbc);
		
		gbc.gridx = 1;  gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		container.add(passwd, gbc);
		
		gbc.gridx = 1;  gbc.gridwidth = 1;
		gbc.gridy = 3; 
		gbc.insets = new Insets(10, 2, 20, 0);
		container.add(valider, gbc);
		
		gbc.gridx = 3;  gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		container.add(abandonner, gbc);
		
		
		this.add(container);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		//this.setResizable(false);
		//this.setVisible(true);
	}


}
