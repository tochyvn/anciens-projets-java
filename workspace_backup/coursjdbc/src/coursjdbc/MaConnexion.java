package coursjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexion {
	
	private String url;
	private String user;
	private String passwd;
	private static Connection connexion;

	private MaConnexion(String url, String user, String passwd) {
		this.url = url;
		this.user = user;
		this.passwd = passwd;
	}
	
	public static Connection getInstance(String url, String user, String passwd) {
		Connection conn = null;
		if (connexion == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				System.out.println("Driver OK");
				//String url = "jdbc:mysql://localhost:8889/SCOLARITE";
				//String user = "toch";
				//String passwd = "toch";
				
				conn = DriverManager.getConnection(url, user, passwd);
				System.out.println("Connexion effective");
			} catch (ClassNotFoundException e) {
				System.out.println("classe non trouvée");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Problème de connexion");
			}
		}
		return conn;
			
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
