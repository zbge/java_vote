<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/8
  Time: 20:48
  Description: 注册界面
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="registerLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="registerLabel" style="text-align: center">注册</h3>
            </div>
            <div class="modal-body">
                <%
                    if (request.getParameter("register") != null)
                    {
                        out.print("<div class=\"input-group\" style=\"width: 60%; margin-left: 20%\">");
                        out.print(request.getParameter("register"));
                        out.print("</div>");
                    }
                %>
                <form class="bs-example bs-example-form" role="form" action="${pageContext.request.contextPath}/register" method="post">
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon ">&nbsp;&nbsp;&nbsp; 昵称 &nbsp;&nbsp;</span>
                        <input type="text" class="form-control" name="nickname" placeholder="请输入昵称，最多20个字符">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon ">&nbsp; 用户名 &nbsp;</span>
                        <input type="text" class="form-control" name="username" placeholder="请输入用户名，6-20位">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">&nbsp;&nbsp;&nbsp; 密码 &nbsp;&nbsp;</span>
                        <input type="password" class="form-control" name="password" placeholder="请输入密码，6-16位">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">重复密码</span>
                        <input type="password" class="form-control" name="again_pwd" placeholder="请再次输入密码">
                    </div>
                    <br>
                    <div class="input-group" style="width: 60%; margin-left: 20%">
                        <span class="input-group-addon">&nbsp;&nbsp;&nbsp; 邮箱 &nbsp;&nbsp;&nbsp;</span>
                        <input type="text" class="form-control" name="email" placeholder="请输入邮箱">
                    </div>
                    <%
                        if (request.getParameter("error") != null)
                        {
                            out.print("<div class=\"input-group\" style=\"width: 60%; margin-left: 20%\">");
                            out.print(request.getParameter("error"));
                            out.print("</div>");
                        }
                    %>
                    <hr>
                    <div style="text-align: center">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="submit" class="btn btn-primary">注册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

