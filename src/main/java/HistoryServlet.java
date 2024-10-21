import config.JDBCConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Translation;

import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private final JDBCConfig jdbcConfig = new JDBCConfig();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Translation> history = jdbcConfig.getTranslationHistory();
        req.setAttribute("history", history);
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }
}
