<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Result</title>
</head>
<body style="background-color: beige">
<h1 style="text-align: center">Your result:</h1>
<hr>
<br>
<h2 style="text-align: center">${result}</h2>
<br>
<br>
<div style="display: flex; justify-content: center;">
  <form action="/">
    <input type="submit" value="Home page">
  </form>
  <form style="margin-left: 50px" action="/history">
    <input type="submit" value="History page">
  </form>
</div>
</body>
</html>
