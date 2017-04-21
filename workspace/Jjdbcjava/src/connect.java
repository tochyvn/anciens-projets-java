


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {

	public connect() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("Driver OK");
			String url = "jdbc:mysql://localhost:8889/TESTJDBC";
			String user = "toch";
			String passwd = "toch";
			
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective");
		} catch (ClassNotFoundException e) {
			System.out.println("classe non trouvée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("ERREUR SQL");
		}
	}

}
