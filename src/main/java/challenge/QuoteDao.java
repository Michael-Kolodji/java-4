package challenge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuoteDao {

	public Quote getQuote() throws SQLException {
		
List<Quote> quotes = new ArrayList<Quote>();
		
        try (Connection connection = new ConnectionFactory().createConnection()) {

            System.out.println("Conexão realizada !!!!");

            // lendo os registros
            PreparedStatement stmt = connection.prepareStatement("select * from scripts where actor like 'Michael%'");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String actor = resultSet.getString("actor");
                String detail = resultSet.getString("detail");
                
                Quote quote = new Quote(actor, detail);
                
                quotes.add(quote);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
		return null;
	}

	public Quote getQuoteByActor(String actor) throws SQLException {
		return null;
	}

}
