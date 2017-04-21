package vue.composant;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class MonCombobox extends JComboBox<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public MonCombobox() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	public MonCombobox(String text) {
		super();
		this.addItem(text);
	}


	public MonCombobox(ComboBoxModel<String> aModel) {
		super(aModel);
		// TODO Auto-generated constructor stub
	}

	public MonCombobox(String[] items) {
		super(items);
	}

	
}
