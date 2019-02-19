<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/10
  Time: 14:30
  Description: 用户找回密码
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="forget" tabindex="-1" role="dialog" aria-labelledby="forgetLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="forgetLabel" style="text-align: center">找回密码</h3>
            </div>
            <div class="modal-body">
                <form class="bs-example bs-example-form" role="form" action="${pageContext.request.contextPath}/forget" method="post">
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon ">&nbsp; 用户名 &nbsp; </span>
                        <input type="text" class="form-control" name="username" placeholder="请输入用户名">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">&nbsp;&nbsp; 邮箱 &nbsp; &nbsp;</span>
                        <input type="text" class="form-control" name="email" placeholder="请输入邮箱">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">&nbsp; &nbsp; 密码 &nbsp; &nbsp;</span>
                        <input type="password" class="form-control" name="password" placeholder="请输入新的密码">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">重复密码</span>
                        <input type="password" class="form-control" name="again_pwd" placeholder="请再次输入密码">
                    </div>
                    <hr>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-danger">找回密码</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

