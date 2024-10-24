<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="stylee.css">
</head>
<body>
<div class="container">
    <h1>Your result:</h1>
    <hr>
    <br>
    <h2>${result}</h2>
    <br>
    <br>
    <div class="button-group">
        <form action="/">
            <input type="submit" value="Вернуться назад">
        </form>
        <form style="margin-left: 50px" action="/history">
            <input type="submit" value="Вернуться к истории">
        </form>
    </div>
</div>
</body>
</html>
