<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Media</title>
    <link rel="stylesheet" type="text/css" href="stylee.css">
</head>
<body>
<div class="container">
    <h1>Upload Image and Audio</h1>
    <form action="/uploadMedia" method="post" enctype="multipart/form-data" id="uploadForm">
        <label for="image">Image:</label>
        <input type="file" id="image" name="image" accept="image/*" required onchange="previewImage(event)"><br><br>

        <label for="audio">Audio:</label>
        <input type="file" id="audio" name="audio" accept="audio/*" required onchange="previewAudio(event)"><br><br>

        <div class="button-group">
            <input type="submit" value="Загрузить в базу данных">
        </div>
    </form>

    <div class="preview" id="preview">
        <img id="imagePreview" src="#" alt="Image Preview" style="display:none;">
        <audio id="audioPreview" controls style="display:none;">
            <source id="audioSource" src="#" type="audio/mpeg">
            Your browser does not support the audio element.
        </audio>
    </div>
</div>

<script>
    function previewImage(event) {
        const imagePreview = document.getElementById('imagePreview');
        imagePreview.src = URL.createObjectURL(event.target.files[0]);
        imagePreview.style.display = 'block';
    }

    function previewAudio(event) {
        const audioPreview = document.getElementById('audioPreview');
        const audioSource = document.getElementById('audioSource');
        audioSource.src = URL.createObjectURL(event.target.files[0]);
        audioPreview.style.display = 'block';
        audioPreview.load();
    }
</script>
</body>
</html>