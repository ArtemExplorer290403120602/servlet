<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Media Display</title>
    <style>
        body {
            background-color: beige;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: auto;
            text-align: center;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        .media {
            margin: 20px 0;
        }
        .media img {
            max-width: 100%; /* Сделаем изображение адаптивным */
            border-radius: 8px;
            border: 2px solid #ccc;
        }
        .audio-container {
            margin-top: 20px;
            background: #f0f0f0;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        audio {
            width: 100%; /* Задаем ширину для аудиопроигрывателя */
            outline: none; /* Убираем стандартный контур */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Media Display</h1>
    <div class="media">
        <img src="data:image/jpeg;base64,<%= request.getAttribute("base64Image") %>" alt="Media Image">
    </div>
    <div class="audio-container">
        <audio controls autoplay>
            <source src="data:audio/mpeg;base64,<%= request.getAttribute("base64Audio") %>" type="audio/mpeg">
            Your browser does not support the audio element.
        </audio>
    </div>
</div>
</body>
</html>