<%@page contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>Hello World!</h2>

<form action="/photo/add" method="post" enctype="multipart/form-data">
    <input type="hidden" name="userId" value="1"/>
    <input type="file" name="photo">
    <input type="submit" value="上传"/>
</form>
</body>
</html>
