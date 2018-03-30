<%--
  Created by IntelliJ IDEA.
  User: huashuo
  Date: 2018/3/20
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${sessionScope.user1.username}</h2>
<<img src="images/${fileName}">
<<a href="download?fileName=${fileName}">点击下载</a>
</body>
</html>