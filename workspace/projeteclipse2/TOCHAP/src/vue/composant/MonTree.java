package vue.composant;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

public class MonTree extends JTree {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonTree() {
		super();
	}
/*
	public MonTree(TreeNode root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	public MonTree(TreeModel newModel) {
		super(newModel);
		// TODO Auto-generated constructor stub
	}

	public MonTree(TreeNode root, boolean asksAllowsChildren) {
		super(root, asksAllowsChildren);
		
	}
	*/
	public void setMonModel(TreeModel newModel) {
		this.setModel(newModel);
		
	}
	
	

	

}
