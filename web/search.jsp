<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/8
  Time: 19:42
  Description: 搜索框
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<form class="navbar-form" role="search" action="${pageContext.request.contextPath}/search" method="get">
    <div class="input-group">
        <input type="text" class="form-control" name="key" placeholder="标题或内容的关键字">
        <span class="input-group-btn">
            <button class="btn btn-default" type="submit">
                <span class="glyphicon glyphicon-search" style="font-size: 20px"></span>
            </button>
        </span>
    </div>
</form>
