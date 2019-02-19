<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/16
  Time: 19:23
  Description: 提示信息页面
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>跳转提示</title>
</head>
<body>
    <div style="margin-top: 10%; text-align: center; font-size: 25px">
        <strong>
            ${info}
        </strong>
        <br><br>
        <strong>将在3秒后跳转至首页，立即跳转—请点击<a href="/">这里</a></strong>
    </div>
</body>
</html>