package modele.metier;

import java.util.List;
import java.util.Vector;


public interface InterfaceGestionHotel {
	
	public abstract int insertEtudiant(Etudiant etudiant);
	
	public abstract int updateEtudiant(String reference, Etudiant etudiant);
	
	public abstract void deleteEtudiant(String reference);
	
	public abstract List<Etudiant> getAllEtudiant();

	public Vector<Vector<String>> getAllEtudiant1();
	
	public boolean ifExistEtudiant(String reference);

}
