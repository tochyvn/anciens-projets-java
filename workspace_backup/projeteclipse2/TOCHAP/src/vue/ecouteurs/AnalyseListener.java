package vue.ecouteurs;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Parameter;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import modele.metier.Attribut;
import modele.metier.Classe;
import modele.metier.Constructeur;
import modele.metier.Methode;
import modele.metier.Parametre;
import controleur.Manager;
import vue.composant.MonScrollPane;
import vue.composant.MonTabbedPane;
import vue.composant.MonTree;

public class AnalyseListener implements ActionListener {
	MonTabbedPane tab;
	MonTree tree;

	public AnalyseListener(MonTabbedPane tab,MonTree tree) {
		this.tab = tab;
		this.tree = tree;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println("Analyse en cours...");
		Component comp = (MonScrollPane)tab.getSelectedComponent();
		int index = tab.indexOfComponent(comp);
		System.out.println("Voici l'index "+index);
		//Recuperation de la zone de saisie
		
		if (index != -1) {
			Manager.getInstance().analyse(index);
			Classe classe= Manager.getInstance().getClasse(index);			
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode(classe.getName());
			DefaultTreeModel model = new DefaultTreeModel(racine) ;
			
			DefaultMutableTreeNode attribut = new DefaultMutableTreeNode("Attribut");
			for (Attribut att : classe.getMesAttributs()) {
				String name = att.getName();
				String type = att.getType();
				int visibilite = att.getPortee();
				DefaultMutableTreeNode attr = new DefaultMutableTreeNode(visibilite+" "+type+" "+name);
				attribut.add(attr);
				racine.add(attribut);
				System.out.println(visibilite+" "+type+" "+name);	
			}
			DefaultMutableTreeNode constructeur = new DefaultMutableTreeNode("constructeurs");
			for (Constructeur constr : classe.getMesConstructeurs()) {
				String name = constr.getName();
				int visibilite = constr.getPortee();
				DefaultMutableTreeNode construct = new DefaultMutableTreeNode(visibilite+" "+name);
				constructeur.add(construct);
				for (Parametre param : constr.getMesParams()) {
					String parameterName = param.getName();
					String parameterType = param.getType();
					DefaultMutableTreeNode parametr = new DefaultMutableTreeNode(parameterType+" "+parameterName);
					construct.add(parametr);
				}
				racine.add(constructeur);
			}
			DefaultMutableTreeNode methode = new DefaultMutableTreeNode("Methodes");
			for (Methode meth : classe.getMesMethodes()) {
				String name = meth.getName();
				String typeRetour = meth.getReturnType();
				int visibilite = meth.getPortee();
				DefaultMutableTreeNode metho = new DefaultMutableTreeNode(visibilite+" "+typeRetour+" "+name);
				methode.add(metho);
				for (Parametre param : meth.getMesParams()) {
					String parameterName = param.getName();
					String parameterType = param.getType();
					DefaultMutableTreeNode parametr = new DefaultMutableTreeNode(parameterType+" "+parameterName);
					metho.add(parametr);
				}
				racine.add(methode);
			}
			tree.setMonModel(model);	
		}

	}
	
}
