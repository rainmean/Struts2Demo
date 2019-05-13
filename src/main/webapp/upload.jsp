<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>文件上传</h3>
    <s:actionerror />
    <form action="upload" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="file" /><br>
        <button>上传</button>
    </form>
</body>
</html>
