<%@ page import="java.util.concurrent.ConcurrentHashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="client.ClientConnectionServlet" %>
<html>
<head>
    <title>Add Translation</title>
    <link rel="stylesheet" type="text/css" href="stylee.css">
</head>
<body>
<div class="container">
    <h1>Add a new Translation</h1>
    <hr>
    <div class="server-info">
        <p>Server IP Address: ${serverAddress}</p>
        <p>Server Port: ${serverPort}</p>
    </div>

    <div class="connected-clients">
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

    <div class="form-container">
        <form action="/translation" method="post" class="translation-form">
            <label for="word">Word:</label>
            <input type="text" id="word" name="word" required>
            <br>
            <label for="translate">Translate:</label>
            <input type="text" id="translate" name="translate" required>
            <br>
            <input type="submit" value="Добавить слово">
        </form>

        <div class="button-group">
            <form action="/history" method="get">
                <input type="submit" value="История">
            </form>
            <form action="/translate" method="get">
                <input type="submit" value="Перевод слова">
            </form>
            <form action="/reverseTranslate" method="get">
                <input type="submit" value="Обратный переод">
            </form>
            <form action="/uploadMedia" method="get">
                <input type="submit" value="Загрузить фото в базу данных">
            </form>
            <form action="/inputId" method="get">
                <input type="submit" value="Показать фото по id">
            </form>
            <form action="/downloadExcel" method="get">
                <input type="submit" value="Загрузить файл excel">
            </form>
        </div>
    </div>
</div>
</body>
</html>