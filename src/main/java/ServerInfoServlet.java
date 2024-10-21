import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/serverInfo")
public class ServerInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String serverAddress = "127.0.0.1"; // Фиктивный IP
        int serverPort = req.getLocalPort();
        req.setAttribute("serverAddress", serverAddress);
        req.setAttribute("serverPort", serverPort);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}