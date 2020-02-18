<%@ page pageEncoding="UTF-8" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/"; %> <!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <style type="text/css"> * {
        font-family: "Arial";
    } </style>
</head>
<body><h1>Hello, World!</h1>
<hr/>
<h2>Current time is: <%= new java.util.Date().toString() %>
</h2></body>
</html>