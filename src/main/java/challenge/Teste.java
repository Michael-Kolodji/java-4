package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste {

	/*
	 * public static void main(String[] args) {
	 * 
	 * Statement stmt = null; Connection connection = null;
	 * 
	 * try { connection = new ConnectionFactory().createConnection(); stmt =
	 * connection.createStatement();
	 * 
	 * // criando uma tabela
	 * stmt.execute("CREATE TABLE IF NOT EXISTS RC_TEST( ID INTEGER, NOME VARCHAR )"
	 * );
	 * 
	 * // inserindo registros stmt.
	 * execute("INSERT INTO RC_TEST( ID, NOME) VALUES (1, 'Wolmir'), (2, 'Garbin')"
	 * );
	 * 
	 * // lendo os registros PreparedStatement pstmt =
	 * connection.prepareStatement("select * from RC_TEST"); ResultSet resultSet =
	 * pstmt.executeQuery();
	 * 
	 * while (resultSet.next()) { Integer id = resultSet.getInt("ID"); String nome =
	 * resultSet.getString("NOME");
	 * 
	 * System.out.println( id + " - " + nome); }
	 * 
	 * 
	 * 
	 * stmt.close(); pstmt.close(); connection.close();
	 * 
	 * } catch (Exception e) { // TODO: handle exception }
	 * 
	 * System.out.println ( "Operação feito com sucesso");
	 * 
	 * }
	 */

	private static void connect() {
        try (Connection connection = new ConnectionFactory().createConnection()) {

            System.out.println("Conexão realizada !!!!");

            // lendo os registros
            PreparedStatement stmt = connection.prepareStatement("select * from scripts where actor like 'Michael%'");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer index = resultSet.getInt("index");
                String actor = resultSet.getString("actor");
                String detail = resultSet.getString("detail");

                System.out.println( index + " - " + actor + " - " + detail);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
	
}
