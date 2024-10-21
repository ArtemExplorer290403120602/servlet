import config.JDBCConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Media;

import java.io.IOException;
import java.util.Base64;

@WebServlet("/displayMedia")
public class MediaDisplayServlet extends HttpServlet {
    private final JDBCConfig jdbcConfig = new JDBCConfig();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam != null) {
            Long id = Long.valueOf(idParam);
            Media media = jdbcConfig.getMedia(id);

            if (media != null) {
                String base64Image = Base64.getEncoder().encodeToString(media.getImage());
                byte[] audio = media.getAudio();
                String base64Audio = Base64.getEncoder().encodeToString(audio);

                // Передаем данные в JSP
                req.setAttribute("base64Image", base64Image);
                req.setAttribute("base64Audio", base64Audio);
                getServletContext().getRequestDispatcher("/display-media.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Media not found for ID: " + id);
                getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "Invalid ID parameter.");
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}