import client.ClientConnectionServlet;
import config.JDBCConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Translation;

import java.io.IOException;

@WebServlet("/translate")
public class TranslateServlet extends HttpServlet {
    private final JDBCConfig jdbcConfig = new JDBCConfig();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Если вы хотите просто отобразить страницу без выполнения каких-либо действий
        getServletContext().getRequestDispatcher("/translate.jsp").forward(req, resp);
        logClientAccess(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        logClientAccess(req);

        // Проверка на пустоту
        if (word == null || word.isBlank()) {
            req.setAttribute("result", "Word cannot be empty");
            getServletContext().getRequestDispatcher("/translate.jsp").forward(req, resp);
            return;
        }

        // Поиск перевода в базе данных
        Translation translation = jdbcConfig.translateWord(word);

        // Проверка, найден ли перевод
        if (translation != null) {
            req.setAttribute("result", translation.getTranslate());
        } else {
            req.setAttribute("result", "Translation not found");
        }

        // Перенаправление обратно на страницу перевода с результатом
        getServletContext().getRequestDispatcher("/translate.jsp").forward(req, resp);
    }

    private void logClientAccess(HttpServletRequest req) {
        String clientIpAddress = req.getRemoteAddr();
        int clientPort = req.getRemotePort();
        String requestUrl = req.getRequestURI();
        ClientConnectionServlet.logClientVisit(clientIpAddress, clientPort, requestUrl);
    }
}