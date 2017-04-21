package vue.composant;

import javax.swing.JSplitPane;

public class MonSplit extends JSplitPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonSplit() {
		super(VERTICAL_SPLIT);
		this.setDividerLocation(400);
		}

}
