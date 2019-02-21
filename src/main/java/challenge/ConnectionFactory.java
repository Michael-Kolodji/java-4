package challenge;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection createConnection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\resources\\database.sqlite");
			if(connection.isClosed()) {
				System.out.println ( "banco de dados falhou");
			} else {
				System.out.println ( "banco de dados aberto com sucesso");
			}
			
		} catch (Exception e) {
			System.err.println (e.getClass().getName () + ":" + e.getMessage ());
			System.exit(0);
		}
		
		return connection;
	}

}
