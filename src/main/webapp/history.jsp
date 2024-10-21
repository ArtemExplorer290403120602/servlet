<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Translation History</title>
</head>
<body style="background-color: beige">
<h1 style="text-align: center">Translation History</h1>
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
<div style="display: flex; justify-content: center; margin-top: 20px;">
  <form action="/">
    <input type="submit" value="Home page">
  </form>
</div>
</body>
</html>
