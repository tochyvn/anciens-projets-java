package modele.metier;

import java.io.Serializable;

public class SaveConnexion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String url;
	private  String user;
	private  String password;

	public SaveConnexion(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
