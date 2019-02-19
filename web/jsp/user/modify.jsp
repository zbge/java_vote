<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/10
  Time: 15:31
  Description: 个人信息修改
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="modifyLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="modifyLabel" style="text-align: center">修改个人信息</h3>
            </div>
            <div class="modal-body">
                <form class="bs-example bs-example-form" role="form" action="${pageContext.request.contextPath}/modify" method="post">
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon ">&nbsp;&nbsp;&nbsp; 昵称 &nbsp;&nbsp;</span>
                        <input type="text" class="form-control" name="nickname" value="<%= user.getNickname() %>" data-toggle="tooltip"  title="请输入昵称，最多20个字符">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon ">&nbsp; 用户名 &nbsp;</span>
                        <input type="text" class="form-control" disabled name="username" value="<%= user.getUsername() %>">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">新的密码</span>
                        <input type="password" class="form-control" name="password" placeholder="请输入新的密码，6-16位" data-toggle="tooltip"  title="若需要修改密码则进行填写，不需要修改则不用填写">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">重复密码</span>
                        <input type="password" class="form-control" name="again_pwd" placeholder="请再次输入新的密码">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">&nbsp;&nbsp;&nbsp; 邮箱 &nbsp;&nbsp;&nbsp;</span>
                        <input type="text" class="form-control" name="email" value="<%= user.getEmail() %>">
                    </div>
                    <hr>
                    <div style="text-align: center">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="submit" class="btn btn-primary">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>