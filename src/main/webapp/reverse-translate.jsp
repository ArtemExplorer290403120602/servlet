<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Reverse Translate</title>
</head>
<body style="background-color: beige">
<h1 style="text-align: center">Reverse Translation</h1>
<hr>
<div style="display: flex; justify-content: center;">
  <form action="/reverseTranslate" method="post">
    <label for="translate">Translate:</label>
    <input type="text" id="translate" name="translate" required>
    <br><br>
    <input type="submit" value="Find Original Word">
  </form>
</div>
<div style="display: flex; justify-content: center; margin-top: 20px;">
  <c:if test="${not empty result}">
    <p>${result}</p>
  </c:if>
</div>
</body>
</html>