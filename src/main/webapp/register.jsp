<%--
  Created by IntelliJ IDEA.
  User: fulia
  Date: 2018/3/20
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Commons/commons.jsp"%>
    <title>Title</title>
    <script src="js/jquery-3.2.1.js">
    </script>

    <script>
        $(function () {
            $("#username").blur(function () {
                $.ajax({
                    url:"user/checkName",
                    data:{"username":$("#username").val(),"_method":"PUT"},
                    success:function(data){
                        $("#msg").text(data);
                    }
                })
            });
        });
    </script>
</head>

<body>
<h2>用户注册</h2>
<p>用户名:<input id="username">
    <span id="msg" style="color: red"></span>
</p>
<p>密码:<input type="password"></p>
<p><input type="submit" value="保存"></p>
<hr>
<form action="test/users" method="post">
    <p><input type="submit" value="保存"></p>
</form>
<p><input type=""></p>

</body>
</html>
