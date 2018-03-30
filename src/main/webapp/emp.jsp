<%--
  Created by IntelliJ IDEA.
  User: huashuo
  Date: 2018/3/23
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%@include file="Commons/commons.jsp"%>
    <title>Title</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>
<p><a href="toEmp?locale=zh_CN"><spring:message code="tittle_zh"></a></p>
    <p><a href="toEmp?locale=en_US"><spring:message code="tittle_en"></a></p>
    <form action="emp/add" method="post">
        <p><spring:message code="ename"></spring:message><input type="text" name="ename">

        <form:errors path="emp.ename" cssClass="error"/>
        </p>
        <p><spring:message code="hiredate"></spring:message><input type="date" name="hiredate">
            <form:errors path="emp.hiredate" cssClass="error"/>
        </p>
        <p><spring:message code="sal"></spring:message><input type="text" name="sal">
            <form:errors path="emp.sal" cssClass="error"/>
        </p>
        <p><input type="submit" value="<spring:message code="submit"></spring:message>"></p>
    </form>
</body>
</html>
