package vue.composant;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class MonSplitPane extends JSplitPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonSplitPane(MonEditor editeur, MonTree arbre, MonTabbedPane tab) {
		super(MonSplitPane.VERTICAL_SPLIT,new MonSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(arbre),tab),new JScrollPane(editeur));
	}
	
	public MonSplitPane(int newOrientation, Component newLeftComponent,
			Component newRightComponent) {
		super(newOrientation, newLeftComponent, newRightComponent);
		
	}

}
