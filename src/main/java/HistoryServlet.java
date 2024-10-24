import client.ClientConnectionServlet;
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
        logClientAccess(req);
        req.setAttribute("history", history);
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }

    private void logClientAccess(HttpServletRequest req) {
        String clientIpAddress = req.getRemoteAddr();
        int clientPort = req.getRemotePort();
        String requestUrl = req.getRequestURI();
        ClientConnectionServlet.logClientVisit(clientIpAddress, clientPort, requestUrl);
    }
}
