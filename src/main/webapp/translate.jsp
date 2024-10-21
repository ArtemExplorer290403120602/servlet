<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate Word</title>
</head>
<body style="background-color: beige">
<h1 style="text-align: center">Translate English to Russian</h1>
<hr>
<div style="display: flex; justify-content: center;">
    <form action="/translate" method="post">
        <label for="word">English Word:</label>
        <input type="text" id="word" name="word" required>
        <br><br>
        <input type="submit" value="Translate">
    </form>
</div>
<div style="text-align: center;">
    <c:if test="${not empty result}">
        <h3>Translation: ${result}</h3>
    </c:if>
</div>
</body>
</html>
