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

		new ConnectionFactory();
		try (Connection connection = ConnectionFactory.createConnection()) {

			if (connection.isClosed()) {
				System.out.println("Conexão falhou");
			} else {
				System.out.println("Conexão realizada");
			}

			PreparedStatement stmt = connection.prepareStatement("select * from scripts");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				String actor = resultSet.getString("actor");
				String quote = resultSet.getString("detail");

				Quote quote2 = new Quote(actor, quote);

				quotes.add(quote2);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		int indexRandom = (int) Math.round(Math.random() * quotes.size());

		return quotes.get(indexRandom);
	}

	public Quote getQuoteByActor(String actor) throws SQLException {

		List<Quote> quotes = new ArrayList<Quote>();

		new ConnectionFactory();
		try (Connection connection = ConnectionFactory.createConnection()) {

			if (connection.isClosed()) {
				System.out.println("Conexão falhou");
			} else {
				System.out.println("Conexão realizada");
			}

			PreparedStatement stmt = connection.prepareStatement("select * from scripts where actor = ?");
			stmt.setString(1, actor);

			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				String name = resultSet.getString("actor");
				String quote = resultSet.getString("detail");

				Quote quote2 = new Quote(name, quote);

				quotes.add(quote2);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		int indexRandom = (int) Math.round(Math.random() * quotes.size());

		return quotes.get(indexRandom);
	}

}
