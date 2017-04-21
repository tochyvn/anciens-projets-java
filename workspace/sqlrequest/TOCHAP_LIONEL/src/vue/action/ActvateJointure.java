package vue.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import controleur.Manager;

/**
 * Classe permettant d'activer ou de desactiver les jointures
 * @author TOCHAP
 *@version 1.0.1
 */
public class ActvateJointure implements ActionListener {

	private JEditorPane joint;
	private JCheckBox activateJoint;
	
	public ActvateJointure(JEditorPane joint, JCheckBox activateJoint) {
		this.joint = joint;
		this.activateJoint = activateJoint;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Si la connection est etablie
		if (Manager.conn != null) {
			if (activateJoint.isSelected() && ItemSelectColonne.vTables.size()>1) {
				Vector<String> jointure = Manager.getInstance().getJointures(ItemSelectColonne.vTables);
				//joint.setText(j.toString());
				String s = "";
				for (String string : jointure) {
					
					if (jointure.indexOf(string) == 0)
						s += "("+string+") ";
					else
						s += " AND ("+string+") ";
				}
				joint.setText(s);
			} else {
				joint.setText("");
			}
		}

	}

}
