<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/8
  Time: 20:47
  Description: 登录界面
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="loginLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="loginLabel" style="text-align: center">登录</h3>
            </div>
            <div class="modal-body">
                <form class="bs-example bs-example-form" role="form" action="${pageContext.request.contextPath}/login" method="post">
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon ">用户名</span>
                        <input type="text" class="form-control" name="username" placeholder="请输入用户名">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">&nbsp; 密码 &nbsp;</span>
                        <input type="password" class="form-control" name="password" placeholder="请输入密码">
                    </div>
                    <span style="width: 60%; margin-left: 20%">${error}</span>
                    <hr>
                    <div style="text-align: center">
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#forget">忘记密码</button>
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <button type="submit" class="btn btn-primary">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="forget.jsp" %>