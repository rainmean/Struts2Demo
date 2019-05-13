<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %><!-- 引入Struts2的标签库 -->
<html>
<head>
    <title>用户编辑</title>
</head>
<body>
    <h3>用户编辑</h3>
    <s:actionerror />
    <s:form action="userSave" method="POST">
        <s:textfield name="user.id" label="用户编号" readonly="true"/>
        <s:textfield name="user.username" label="用户名"/>
        <s:password name="user.password" label="密码"/>
        <s:radio list="#{'男':'男','女':'女','保密':'保密'}" name="user.sex" label="性别"/>
        <s:submit value="提交"/>
    </s:form>
</body>
</html>
