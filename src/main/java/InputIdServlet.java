import client.ClientConnectionServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/inputId")
public class InputIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/input-id.jsp").forward(req, resp);
        logClientAccess(req);
    }

    private void logClientAccess(HttpServletRequest req) {
        String clientIpAddress = req.getRemoteAddr();
        int clientPort = req.getRemotePort();
        String requestUrl = req.getRequestURI();
        ClientConnectionServlet.logClientVisit(clientIpAddress, clientPort, requestUrl);
    }
}
