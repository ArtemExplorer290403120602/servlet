<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reverse Translate</title>
    <link rel="stylesheet" type="text/css" href="stylee.css">
</head>
<body>
<div class="container">
    <h1>Reverse Translation</h1>
    <hr>
    <div class="button-group">
        <form action="/reverseTranslate" method="post">
            <label for="translate">Translate:</label>
            <input type="text" id="translate" name="translate" required>
            <br><br>
            <input type="submit" value="Перевести обратный перевод">
        </form>
    </div>
    <div>
        <c:if test="${not empty result}">
            <p>${result}</p>
        </c:if>
    </div>
</div>
</body>
</html>