<%--
  Created by IntelliJ IDEA.
  User: huashuo
  Date: 2018/3/21
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="Commons/commons.jsp"%>
<body>
   <ul>
       <c:forEach items="${users}" var="user">
           <li><a href="/test/users/${user.userId}">${user.userName}</a> </li>
       </c:forEach>
   </ul>

</body>
</html>
