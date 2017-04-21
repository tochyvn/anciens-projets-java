package model.metier;

public class CompteUtilisateur {
	
	private String username;
	private String password;
	
	public CompteUtilisateur() {
		super();
	}

	public CompteUtilisateur(String username, String password) {
		super();
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
