
Копировать
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Input Media ID</title>
</head>
<body>
<h1>Enter Media ID</h1>
<form action="displayMedia" method="get">
    <label for="id">Media ID:</label>
    <input type="text" id="id" name="id" required>
    <input type="submit" value="Display Media">
</form>
</body>
</html>