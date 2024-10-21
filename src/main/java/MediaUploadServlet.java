import config.JDBCConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Media;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/uploadMedia")
@MultipartConfig
public class MediaUploadServlet extends HttpServlet {
    private final JDBCConfig jdbcConfig = new JDBCConfig();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Отправка HTML-формы для загрузки медиа
        getServletContext().getRequestDispatcher("/upload-media.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part imagePart = req.getPart("image");
        Part audioPart = req.getPart("audio");

        byte[] imageBytes = convertPartToBytes(imagePart);
        byte[] audioBytes = convertPartToBytes(audioPart);

        Media media = new Media();
        media.setImage(imageBytes);
        media.setAudio(audioBytes);

        // Сохранение медиа в базу данных
        jdbcConfig.addMedia(media);

        resp.sendRedirect("success.jsp");
    }

    private byte[] convertPartToBytes(Part part) throws IOException {
        try (InputStream inputStream = part.getInputStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }
}