<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3 style="color:red;">文件上传失败！</h3>
    <s:fielderror />
    <s:actionerror />
    <s:debug /><!-- 提供一个查看debug信息的链接 -->
</body>
</html>
