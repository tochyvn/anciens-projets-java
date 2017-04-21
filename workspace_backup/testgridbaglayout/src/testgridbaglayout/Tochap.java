package testgridbaglayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tochap extends JFrame {

	public Tochap() {
		this.setTitle("GridBagLayout");
		this.setSize(300, 160);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//On cree nos differents containers de couleurs differentes
		JPanel cell1 = new JPanel();
		cell1.setBackground(Color.YELLOW);
		cell1.setPreferredSize(new Dimension(60, 40));
		JPanel cell2 = new JPanel();
		cell2.setBackground(Color.red);
		cell2.setPreferredSize(new Dimension(60, 40));
		JPanel cell3 = new JPanel();
		cell3.setBackground(Color.green);
		cell3.setPreferredSize(new Dimension(60, 40));
		JPanel cell4 = new JPanel();
		cell4.setBackground(Color.black);
		cell4.setPreferredSize(new Dimension(60, 40));
		JPanel cell5 = new JPanel();
		cell5.setBackground(Color.cyan);
		cell5.setPreferredSize(new Dimension(60, 40));
		JPanel cell6 = new JPanel(); 
		cell6.setBackground(Color.BLUE); 
		cell6.setPreferredSize(new Dimension(60, 40)); 
		JPanel cell7 = new JPanel(); 
		cell7.setBackground(Color.orange); 
		cell7.setPreferredSize(new Dimension(60, 40)); 
		JPanel cell8 = new JPanel(); 
		cell8.setBackground(Color.DARK_GRAY); 
		cell8.setPreferredSize(new Dimension(60, 40));
		
		//Le conteneur principal
		JPanel content = new JPanel(); 
		content.setBackground(Color.WHITE); 
		content.setPreferredSize(new Dimension(300, 120));
		//On definit son layout
		content.setLayout(new GridBagLayout());
		
		//L'objet servant à positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();
		
		//On positionne la case de depart du composant
		gbc.gridx = 0;
		gbc.gridy = 0;
		//Sa taille en largeur et en hauteur
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 15, 0, 0);
		content.add(cell1, gbc);
		//--------------------------------------------------------------------
		gbc.gridx = 1;
		content.add(cell2, gbc);
		//--------------------------------------------------------------------
		gbc.gridx = 2;
		content.add(cell3, gbc);
		//--------------------------------------------------------------------
		//Cette instruction informe le layout que c'est une fin de ligne
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.gridx = 3;
		content.add(cell4, gbc);
		//-------------------------------------------------------------------------
		gbc.gridx = 1;
		//gbc.gridy = 1;
		gbc.weightx=1;
		gbc.weighty=1;
		//gbc.gridwidth = 0;
		gbc.gridheight = 2;
		//celle-ci indique que la cellule se replique de façon verticale
		//gbc.fill = GridBagConstraints.VERTICAL;
		content.add(cell5, gbc);
		this.setContentPane(content);
		this.setVisible(true);
	}
	
	public static void main(String[] arg) {
		Tochap toch = new Tochap();
		
	}

	
	/*
	 Grid gbl_panel = new Grid();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Table");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 4;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 0;
		this.add(comboBox_1, gbc_comboBox_1);
	 */

}
