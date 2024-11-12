import config.JDBCConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Media;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/uploadMediaFromUrl")
public class MediaUploadFromUrlServlet extends HttpServlet {
    private final JDBCConfig jdbcConfig = new JDBCConfig();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageUrl = req.getParameter("imageUrl");
        String audioUrl = req.getParameter("audioUrl");

        Media media = new Media();
        media.setImage(downloadFile(imageUrl));
        media.setAudio(downloadFile(audioUrl));

        // Сохранение медиа в базу данных
        jdbcConfig.addMedia(media);

        // Получаем ID последнего добавленного медиафайла
        Long mediaId = jdbcConfig.getLastInsertedMediaId();

        // Перенаправление на страницу отображения медиа
        resp.sendRedirect("displayMedia?id=" + mediaId);
    }

    private byte[] downloadFile(String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream inputStream = connection.getInputStream();
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
