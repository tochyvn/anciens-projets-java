package vue.application;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import controleur.Manager;
import modele.metier.Etudiant;
import modele.metier.EtudiantException;
import vue.composant.EtudiantModel;
import vue.composant.TableRender;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class applicationGraphique extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7224707248160026853L;
	private JPanel contentPane;
	private JTable table;
	private JPanel panel_2;
	private JLabel lblSaisieDesInformations;
	private JLabel lblNom;
	private JTextField textField;
	private JLabel lblNom_1;
	private JTextField textField_1;
	private JLabel lblPrenom;
	private JTextField textField_2;
	private JLabel lblSpcialit;
	private JTextField textField_3;
	private JPanel panel_3;
	private JButton btnAjouter_1;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnRaz;
	private EtudiantModel etudiantModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applicationGraphique frame = new applicationGraphique();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public applicationGraphique() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 700);
		//setBounds(400, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(0, 0, 0));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 0.0;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		//gbc_panel_1.gridheight = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblSaisieDesInformations = new JLabel("Saisie des informations sur l'etudiant");
		lblSaisieDesInformations.setBorder(new EmptyBorder(5, 5, 5, 5));
		Font fonte1 = new Font(" Courier ", Font.BOLD+Font.ITALIC, 20);
		lblSaisieDesInformations.setFont(fonte1);
		lblSaisieDesInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaisieDesInformations.setForeground(Color.WHITE);
		lblSaisieDesInformations.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblSaisieDesInformations = new GridBagConstraints();
		gbc_lblSaisieDesInformations.insets = new Insets(10, 0, 5, 0);
		gbc_lblSaisieDesInformations.gridx = 0;
		gbc_lblSaisieDesInformations.gridy = 0;
		gbc_lblSaisieDesInformations.gridwidth = GridBagConstraints.REMAINDER;
		gbc_lblSaisieDesInformations.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSaisieDesInformations.anchor = GridBagConstraints.CENTER;
		panel_1.add(lblSaisieDesInformations, gbc_lblSaisieDesInformations);
		
		Font fonte_label = new Font(" Courier ", Font.BOLD+Font.ITALIC, 17);
		
		lblNom = new JLabel("Reference : ");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(fonte_label);
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 5, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 2;
		panel_1.add(lblNom, gbc_lblNom);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(140, 40));
		textField.setMinimumSize(new Dimension(140, 40));
		textField.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 17));
		System.out.println("-----"+textField.getFont().getStyle());
		System.out.println("-----"+textField.getFont().getSize());
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.weightx = 0.5;
		gbc_textField.insets = new Insets(0, 0, 5, 15);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNom_1 = new JLabel("Nom : ");
		lblNom_1.setForeground(Color.WHITE);
		lblNom_1.setFont(fonte_label);
		GridBagConstraints gbc_lblNom_1 = new GridBagConstraints();
		gbc_lblNom_1.anchor = GridBagConstraints.EAST;
		gbc_lblNom_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNom_1.gridx = 0;
		gbc_lblNom_1.gridy = 3;
		panel_1.add(lblNom_1, gbc_lblNom_1);
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(140, 35));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 15);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(fonte_label);
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.anchor = GridBagConstraints.EAST;
		gbc_lblPrenom.insets = new Insets(0, 10, 5, 5);
		gbc_lblPrenom.gridx = 0;
		gbc_lblPrenom.gridy = 4;
		panel_1.add(lblPrenom, gbc_lblPrenom);
		
		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(140, 35));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 15);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblSpcialit = new JLabel("Spécialité : ");
		lblSpcialit.setForeground(Color.WHITE);
		lblSpcialit.setFont(fonte_label);
		GridBagConstraints gbc_lblSpcialit = new GridBagConstraints();
		gbc_lblSpcialit.anchor = GridBagConstraints.EAST;
		gbc_lblSpcialit.weightx = 0.5;
		gbc_lblSpcialit.insets = new Insets(0, 10, 5, 5);
		gbc_lblSpcialit.gridx = 0;
		gbc_lblSpcialit.gridy = 5;
		panel_1.add(lblSpcialit, gbc_lblSpcialit);
		
		textField_3 = new JTextField();
		textField_3.setPreferredSize(new Dimension(140, 35));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 15);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.weighty = 0.0;
		//gbc_panel_3.gridheight = 1;
		//gbc_panel_3.gridwidth = 1;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 6;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		btnAjouter_1 = new JButton("AJOUTER");
		btnAjouter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reference = textField.getText();
				String nom = textField_1.getText();
				String prenom  = textField_2.getText();
				String specialite = textField_3.getText();
				System.out.println(reference);
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(specialite);
				Etudiant etudiant = null;
				try {
					System.out.println("Try to create an instance of student");
					etudiant = new Etudiant(reference, nom, prenom, specialite);
					Manager.getInstance().addEtudiant(etudiant);
					raz();
					etudiantModel.setData(Manager.getInstance().getEtudiants());
					System.out.println("Create student success");
				} catch (EtudiantException e1) {
					System.out.println("Certains champs sont vides");
				}
				
			}
		});
		btnAjouter_1.setPreferredSize(new Dimension(200, 40));
		GridBagConstraints gbc_btnAjouter_1 = new GridBagConstraints();
		gbc_btnAjouter_1.weightx = 0.1;
		gbc_btnAjouter_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnAjouter_1.gridwidth = 1;
		gbc_btnAjouter_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouter_1.gridx = 0;
		gbc_btnAjouter_1.gridy = 1;
		panel_3.add(btnAjouter_1, gbc_btnAjouter_1);
		
		btnModifier = new JButton("MODIFIER");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reference = textField.getText();
				String nom = textField_1.getText();
				String prenom  = textField_2.getText();
				String specialite = textField_3.getText();
				Etudiant etudiant = null;
				try {
					System.out.println("Try to update an instance of student");
					etudiant = new Etudiant(reference, nom, prenom, specialite);
					Manager.getInstance().updateEtudiant(reference, etudiant);
					raz();
					etudiantModel.setData(Manager.getInstance().getEtudiants());
					System.out.println("Update student success");
				} catch (EtudiantException e1) {
					System.out.println("Update error");
				}
				
			}
		});
		btnModifier.setPreferredSize(new Dimension(200, 40));
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.weightx = 0.1;
		gbc_btnModifier.insets = new Insets(0, 0, 0, 5);
		gbc_btnModifier.gridwidth = 1;
		gbc_btnModifier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifier.gridx = 4;
		gbc_btnModifier.gridy = 1;
		panel_3.add(btnModifier, gbc_btnModifier);
		
		btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reference = textField.getText();
				try {
					Manager.getInstance().deleteEtudiant(reference);
				} catch (EtudiantException e1) {}
				raz();
				etudiantModel.setData(Manager.getInstance().getEtudiants());
			}
		});
		btnSupprimer.setPreferredSize(new Dimension(200, 40));
		//btnSupprimer.setSize(5, 5);
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimer.weightx = 0.1;
		gbc_btnSupprimer.gridwidth = 1;
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.gridx = 7;
		gbc_btnSupprimer.gridy = 1;
		panel_3.add(btnSupprimer, gbc_btnSupprimer);
		
		btnRaz = new JButton("RAZ");
		
		btnRaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				raz();
			}
		});
		
		btnRaz.setPreferredSize(new Dimension(200, 40));
		GridBagConstraints gbc_btnRaz = new GridBagConstraints();
		gbc_btnRaz.insets = new Insets(0, 0, 0, 5);
		gbc_btnRaz.weightx = 0.1;
		gbc_btnRaz.gridwidth = 1;
		gbc_btnRaz.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRaz.gridx = 0;
		gbc_btnRaz.gridy = 2;
		panel_3.add(btnRaz, gbc_btnRaz);
		
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.weightx = 0.0;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridheight = 4;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		contentPane.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(5, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 0.5;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		
		panel.setLayout(new GridLayout(1, 0));
		etudiantModel = new EtudiantModel();
		etudiantModel.setData(Manager.getInstance().getEtudiants());
		table = new JTable(etudiantModel);
		table.setDefaultRenderer(Object.class, new TableRender());
		table.setGridColor(Color.ORANGE);
		Font fonte = new Font(" Courier ", Font.BOLD, 14);
		
		//Modifier la font des headers
		table.getTableHeader().setFont(fonte);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(Color.BLACK);
		table.setFont(fonte);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		table.setRowHeight(30);
		table.setIntercellSpacing(new Dimension(2, 2));
		//Modifier la couleur d'une seule colonne
		System.out.println(table.getColumnModel().getColumn(3));
		System.out.println(table.getIntercellSpacing().getWidth());
		System.out.println(table.getIntercellSpacing().getHeight());
		//Auto dimensionnement des cellules
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//TRI sur les colonnes
		table.setRowSorter(new TableRowSorter<EtudiantModel>(etudiantModel));
		table.setAutoCreateRowSorter(true);
		panel.add(new JScrollPane(table));
		
	}
	
	/**
	 * 
	 */
	public void raz() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
	}

}
