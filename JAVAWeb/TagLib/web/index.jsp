<%--
  Created by IntelliJ IDEA.
  User: ChenLiJian
  Date: 2020/2/19
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="my" uri="/WEB-INF/tld/my.tld" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%> <!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <style type="text/css"> * {
        font-family: "Arial";
        font-size: 72px;
    } </style>
</head>
<body><my:time format="yyyy-MM-dd" backColor="blue" foreColor="yellow"/></body>
</html>
