package challenge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Quote quote;
			String pathInfo = req.getPathInfo();
			if (pathInfo == null || pathInfo.equals("/")) {
				quote = new QuoteDao().getQuote();
			} else {
				String actor = pathInfo.split("/")[1];
				quote = new QuoteDao().getQuoteByActor(actor);
			}

			PrintWriter out = resp.getWriter();
			String obj = "{\"actor\":\"" + quote.getActor() + "\",\"quote\":\"" + quote.getQuote() + "\"}";
			out.print(obj);
			out.flush();

			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
