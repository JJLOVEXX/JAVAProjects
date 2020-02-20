<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Photo Upload</title></head>
<body>
<h1>Select your photo and upload</h1>
<hr/>
<div style="color:red;font-size:14px;">${hint}</div>
<form action="UploadServlet" method="post" enctype="multipart/form-data"> Photo file: <input type="file" name="photo"/>
    <input type="submit" value="Upload"/></form>
</body>
</html>
