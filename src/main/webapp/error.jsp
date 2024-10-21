<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Error</title>
</head>
<body>
<h1>Error</h1>
<p><%= request.getAttribute("errorMessage") %></p>
<a href="index.jsp">Back</a>
</body>
</html>
