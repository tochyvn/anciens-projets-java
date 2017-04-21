package modele.technique;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class EditLoader<T> extends ClassLoader {

	public EditLoader() {
		super();
	}

	public Class<T> loadEdiClass(String cheminAbsolu, String nomClasse) throws ClassNotFoundException, FileNotFoundException
	{ 
		Class<T> ret = null;
		byte buffer[] = null;
		InputStream is = null;
		is = new FileInputStream(cheminAbsolu+nomClasse+".class");
		try
		{
			buffer = new byte[is.available()]; 
			is.read(buffer); 
			ret = (Class<T>) defineClass(nomClasse, buffer, 0, buffer.length); 
			resolveClass(ret); 
			is.close();
		}
		catch(IOException e)
		{
			throw new ClassNotFoundException(nomClasse);		
		}
		return ret; 
	} 

}
