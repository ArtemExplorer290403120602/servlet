<%@ page import="java.util.concurrent.ConcurrentHashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="client.ClientConnectionServlet" %>
<%@ page import="java.util.concurrent.ConcurrentHashMap" %>
<html>
<head>
    <title>Add Translation</title>
</head>
<body style="background-color: beige">
<h1 style="text-align: center">Add a new Translation</h1>
<hr>
<div style="text-align: center;">
    <p>Server IP Address: ${serverAddress}</p>
    <p>Server Port: ${serverPort}</p>
</div>
<div style="text-align: center;">
    <h2>Connected Clients:</h2>
    <ul>
        <%
            ConcurrentHashMap<String, Integer> clients = ClientConnectionServlet.getClientConnections();
            for (String ip : clients.keySet()) {
                out.println("<li>" + ip + ":" + clients.get(ip) + "</li>");
            }
        %>
    </ul>
</div>
<div style="display: flex; justify-content: center;">
    <form action="/translation" method="post">
        <label for="word">Word:</label>
        <input type="text" id="word" name="word" required>
        <br><br>
        <label for="translate">Translate:</label>
        <input type="text" id="translate" name="translate" required>
        <br><br>
        <input type="submit" value="Add Translation">
    </form>
</div>
<div style="display: flex; justify-content: center;">
    <form action="/history" method="get">
        <input type="submit" value="History">
    </form>
</div>
<div style="display: flex; justify-content: center; margin-top: 20px;">
    <form action="/translate" method="get">
        <input type="submit" value="Translate Word">
    </form>
</div>
<div style="display: flex; justify-content: center; margin-top: 20px;">
    <form action="/reverseTranslate" method="get">
        <input type="submit" value="Reverse translate">
    </form>
</div>
</body>
</html>