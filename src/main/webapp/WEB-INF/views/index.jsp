<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ImageView</title>

    <style>
        img{
            max-width:180px;
        }
        input[type=file]{
            padding:10px;
            background:#2d2d2d;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/images" method="post" enctype="multipart/form-data">
    <input type='file' multiple="multiple" onchange="readURL(this);" name="files" />
    <img id="blah" src="http://placehold.it/180" alt="your image" />
    <input type="submit" value="전">
</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</html>
