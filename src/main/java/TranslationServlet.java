import config.JDBCConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Translation;

import java.io.IOException;


@WebServlet("/translation")
public class TranslationServlet extends HttpServlet {
    private final JDBCConfig jdbcConfig = new JDBCConfig();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        String translate = req.getParameter("translate");

        // Проверка на пустоту
        if (word == null || word.isBlank() || translate == null || translate.isBlank()) {
            req.setAttribute("result", "Word or translation cannot be empty");
            getServletContext().getRequestDispatcher("/result-page.jsp").forward(req, resp);
            return;
        }

        // Создание объекта Translation
        Translation translation = new Translation();
        translation.setWord(word);
        translation.setTranslate(translate);

        // Добавление перевода в базу данных
        jdbcConfig.addTranslation(translation);

        // Здесь вы можете выполнить дополнительные действия, такие как перенаправление на страницу с результатами
        req.setAttribute("result", "Translation added: " + word + " -> " + translate);
        getServletContext().getRequestDispatcher("/result-page.jsp").forward(req, resp);
    }
}
