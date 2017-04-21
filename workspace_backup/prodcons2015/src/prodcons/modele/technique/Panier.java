package prodcons.modele.technique;

import java.util.Stack;

public class Panier extends Stack<Character> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int TAILLE = 3;
	public Panier() {
		super();
	
	}
	public synchronized char prendre()
	{
		char ret = ' ';
		while(isEmpty())
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ret = this.pop();
		notifyAll();
		return ret;
	}
	public synchronized void poser(char c)
	{
		while(size() >= TAILLE)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		push(c);
		notifyAll();
	}

}
