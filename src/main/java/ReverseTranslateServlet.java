import config.JDBCConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Translation;

import java.io.IOException;

@WebServlet("/reverseTranslate")
public class ReverseTranslateServlet extends HttpServlet {
    private final JDBCConfig jdbcConfig = new JDBCConfig();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Простой запрос для отображения страницы обратного перевода
        getServletContext().getRequestDispatcher("/reverse-translate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String translate = req.getParameter("translate");

        // Проверка на пустоту
        if (translate == null || translate.isBlank()) {
            req.setAttribute("result", "Translation cannot be empty.");
            getServletContext().getRequestDispatcher("/reverse-translate.jsp").forward(req, resp);
            return;
        }

        // Поиск слова в базе данных
        Translation translation = jdbcConfig.reverseTranslate(translate);

        // Проверка, найдено ли слово
        if (translation != null) {
            req.setAttribute("result", "Original word: " + translation.getWord());
        } else {
            req.setAttribute("result", "Original word not found.");
        }

        // Перенаправление обратно на страницу обратного перевода с результатом
        getServletContext().getRequestDispatcher("/reverse-translate.jsp").forward(req, resp);
    }
}