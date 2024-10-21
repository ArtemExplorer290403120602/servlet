<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Media</title>
</head>
<body>
<h1>Upload Image and Audio</h1>
<form action="/uploadMedia" method="post" enctype="multipart/form-data">
    <label for="image">Image:</label>
    <input type="file" id="image" name="image" accept="image/*" required><br><br>

    <label for="audio">Audio:</label>
    <input type="file" id="audio" name="audio" accept="audio/*" required><br><br>

    <input type="submit" value="Upload">
</form>
</body>
</html>