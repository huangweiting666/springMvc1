<%--
  Created by IntelliJ IDEA.
  User: huashuo
  Date: 2018/3/23
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${emp.hiredate}</p>
<p>${emp.sal}</p>
<p><spring:eval expression="emp.hiredate"></spring:eval></p>
<p><spring:eval expression="emp.sal"></spring:eval></p>
</body>
</html>
