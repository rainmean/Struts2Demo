<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <h3>用户登录</h3>
    <s:actionerror />
    <form action="login" method="post">
        用户名：<input type="text" name="username" /><br>
        密码：<input type="password" name="password" /><br>
        <button>登录</button>
    </form>
</body>
</html>
