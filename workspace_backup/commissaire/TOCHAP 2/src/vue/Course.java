package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JApplet;

import components.MonLabel;
import components.MonProgressBar;
import controleur.Manager;
/**
 * Classe Course
 * @author TOCHAP 
 * @version v1.0
 */
public class Course extends JApplet implements Affichage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Collection contenant toutes les barres de progressions necessaires à l'affichage du deplacement des courreurs
	 */
	private ArrayList<MonProgressBar> mesProgressBar;
	/**
	 * Label permettant d'afficher le compte à rebours
	 */
	private MonLabel monLabel;
	/**
	 * Constructeur de la classe Course
	 * @throws HeadlessException
	 */
	public Course() throws HeadlessException {
		super();
		mesProgressBar = new ArrayList<MonProgressBar>();
		monLabel = new MonLabel();
	}
	
	@Override
	public void init() {

		setLayout(new GridLayout(6,2));
		setSize(600,350);
		mesProgressBar.add(new MonProgressBar(Color.GREEN, true, "LIEVRE"));
		mesProgressBar.add(new MonProgressBar(Color.MAGENTA, false, "LIEVRE"));
		mesProgressBar.add(new MonProgressBar(Color.GREEN, true, "LION"));
		mesProgressBar.add(new MonProgressBar(Color.darkGray, false, "LION"));
		mesProgressBar.add(new MonProgressBar(Color.GREEN, true, "TORTUE"));
		mesProgressBar.add(new MonProgressBar(Color.orange, false, "TORTUE"));
		mesProgressBar.add(new MonProgressBar(Color.GREEN, true, "OULA"));
		mesProgressBar.add(new MonProgressBar(Color.YELLOW, false, "OULA"));
		mesProgressBar.add(new MonProgressBar(Color.GREEN, true, "AMY"));
		mesProgressBar.add(new MonProgressBar(Color.BLACK, false, "AMY"));
		for (int i = 0; i < mesProgressBar.size(); i++) {
			this.add(mesProgressBar.get(i));
		}
		this.add(monLabel);
		this.go();
		super.init();
		
	}
	/**
	 * Methode permettant d'afficher le deplacement de chaque courreur dans sa barre de progression
	 */
	@Override
	public void afficheProgress(int id, int position, String s) {
		this.tabPair().get(id).setValue(position);
		this.tabPair().get(id).setString(s);
		//this.tabImpair().get(id).setString(s);
		this.tabImpair().get(id).setValue(position);
		System.out.println(position);
	}
	/**
	 * Methode permettant d'afficher le compte à rebours
	 */
	@Override
	public void affichageRebours(String s) {
		this.monLabel.setText(s);

	}
	/**
	 * Methode permettant de lancer la course
	 */
	public void go() {
		Manager.getInstance().setVue(this);
		for (int i = 0; i < tabPair().size(); i++) {
			Manager.getInstance().initialize(tabPair().get(i).getString());
		}
		Manager.getInstance().go();
	}
	/**
	 * Methode permettant de recuperer tout les barres dont l'indice dans la collection est paire
	 * @return une collection de barres de progressions
	 */
	private ArrayList<MonProgressBar> tabPair() {
		ArrayList<MonProgressBar> v1 = new ArrayList<MonProgressBar>();
		for (int i = 0; i < mesProgressBar.size(); i++) {
			if ((i % 2) == 0) {
				v1.add(mesProgressBar.get(i));
			}
		}
		return v1;
	}
	/**
	 * Methode permettant de recuperer tout les barres dont l'indice dans la collection est impaire
	 * @return une collection de barres de progressions
	 */
	private ArrayList<MonProgressBar> tabImpair() {
		ArrayList<MonProgressBar> v1 = new ArrayList<MonProgressBar>();
		for (int i = 0; i < mesProgressBar.size(); i++) {
			if ((i % 2) != 0) {
				v1.add(mesProgressBar.get(i));
			}
		}
		return v1;
	}

	

}
