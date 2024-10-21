<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Media Display</title>
</head>
<body>
<h1>Media Display</h1>
<img src="data:image/jpeg;base64,<%= request.getAttribute("base64Image") %>" alt="Media Image" style="width:300px;"><br>
<audio controls autoplay>
    <source src="data:audio/mpeg;base64,<%= request.getAttribute("base64Audio") %>" type="audio/mpeg">
    Your browser does not support the audio element.
</audio>
</body>
</html>
