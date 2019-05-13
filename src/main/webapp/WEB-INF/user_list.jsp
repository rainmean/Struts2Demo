<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %><!-- 引入Struts2的标签库 -->
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <h3>用户列表</h3>
    <s:actionerror />
    <s:actionmessage />
    <table border="1" width="400">
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>操作</th>
        </tr>
        <s:iterator value="userList">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="username"/></td>
            <td><s:property value="password"/></td>
            <td><s:property value="sex"/></td>
            <td>
                <a href="userEdit?id=<s:property value="id"/>">修改</a>
                |
                <a href="userDelete?id=<s:property value="id"/>">删除</a>
            </td>
        </tr>
        </s:iterator>
        <a href="userEdit">添加用户</a>
    </table>
</body>
</html>
