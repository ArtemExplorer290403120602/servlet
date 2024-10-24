<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Translation History</title>
  <link rel="stylesheet" type="text/css" href="stylee.css">
</head>
<body>
<div class="container">
  <h1>Translation History</h1>
  <hr>
  <table style="margin-left: auto; margin-right: auto; border-collapse: collapse; width: 50%;">
    <tr>
      <th style="border: 1px solid black; padding: 8px;">Word</th>
      <th style="border: 1px solid black; padding: 8px;">Translate</th>
    </tr>
    <c:forEach var="item" items="${history}">
      <tr>
        <td style="border: 1px solid black; padding: 8px;">${item.word}</td>
        <td style="border: 1px solid black; padding: 8px;">${item.translate}</td>
      </tr>
    </c:forEach>
  </table>
  <div class="button-group">
    <form action="/">
      <input type="submit" value="Вернуться на главную">
    </form>
  </div>
</div>
</body>
</html>
