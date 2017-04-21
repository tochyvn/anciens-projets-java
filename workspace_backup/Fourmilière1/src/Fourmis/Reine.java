package Fourmis;

import Application.TestFourmiliere;
import Fourmilière.Fourmiliere;
import Message.Message;
import Message.Messagerie;
import Message.Naissance;

/**
 * 
 * @author Tochap
 *
 */
public class Reine extends Fourmi{
	
	public Reine(int cycleVie) {
		super(cycleVie);
	}
	@Override
	public void comportement(Fourmiliere f) {
		
	    
		//si le nombre de cycle est un multiple de 5, elle fait naitre
		if ( TestFourmiliere.i % 5 == 0  ) {
			
			Message msg = new Naissance(this);
			Messagerie.getInstance().addMessage(msg);
		    msg.Notification();
		    
	  }//fin if
        
        
		
	}
    	

    }
