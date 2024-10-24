<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate Word</title>
    <link rel="stylesheet" type="text/css" href="stylee.css">
</head>
<body>
<div class="container">
    <h1 Translate English to Russian</h1>
    <hr>
    <div class="button-group">
        <form action="/translate" method="post">
            <label for="word">English Word:</label>
            <input type="text" id="word" name="word" required>
            <br><br>
            <input type="submit" value="Перевести">
        </form>
    </div>
    <div >
        <c:if test="${not empty result}">
            <h3>Translation: ${result}</h3>
        </c:if>
    </div>
</div>
</body>
</html>
