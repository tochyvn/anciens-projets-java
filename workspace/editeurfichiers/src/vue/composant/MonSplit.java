package vue.composant;

import javax.swing.JSplitPane;

public class MonSplit extends JSplitPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private MonPanel pan1 = new MonPanel();
	//private MonPanel pan2 = new MonPanel();
	private MonArborescence arbre = new MonArborescence();

	public MonSplit() {
		super(JSplitPane.HORIZONTAL_SPLIT);
		this.setDividerLocation(150);
		this.add(arbre, 0);
		this.add(new MonPanel());
	}


}
