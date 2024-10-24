package client;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/clientConnection")
public class ClientConnectionServlet extends HttpServlet {
    private static final ConcurrentHashMap<String, Integer> clientConnections = new ConcurrentHashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientInfo = req.getParameter("clientInfo");
        String[] parts = clientInfo.split(":");
        String ipAddress = parts[0];
        int port = Integer.parseInt(parts[1]);

        // Добавление информации о клиенте
        clientConnections.put(ipAddress, port);

        resp.getWriter().write("Client connected: " + clientInfo);
    }

    public static ConcurrentHashMap<String, Integer> getClientConnections() {
        return clientConnections;
    }

    // Новый метод для логирования переходов клиентов
    public static void logClientVisit(String ipAddress, int port, String path) {
        System.out.println("Client accessed URL: " + path + " from IP: " + ipAddress + " and port: " + port);
    }
}