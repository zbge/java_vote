<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/8
  Time: 16:50
  Description: 投票网站导航栏
--%>
<%@ page import="com.vote.jdbc.domain.User" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header" style="padding-left: 50px">
            <a class="navbar-brand"><img style="max-width:100px;margin-top:-15px;" src="${pageContext.request.contextPath}/static/image/icon.png" alt="木杉投票"></a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse" style="color: rgb(170,170,170);">
                <span class="sr-only">切换导航</span>
                <span class="glyphicon glyphicon-list"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <a href="/">首页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/?time=not_start">未开始</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/?time=starting">正在进行</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/?time=end">已结束</a>
                </li>
                <li>
                    <%@ include file="search.jsp" %>
                </li>
            </ul>
            <%
                User user = (User) session.getAttribute("user");
                if (user == null) {
            %>
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-right: 10px">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#register" style="margin-top: 7px">
                        <span class="glyphicon glyphicon-user"></span> 注册
                    </button>
                </li>
                <li style="padding-right: 50px">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#login" style="margin-top: 7px">
                        <span class="glyphicon glyphicon-log-in"></span> 登录
                    </button>
                </li>
            </ul>
            <% } else { %>
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-right: 10px">
                    <span style="font-size: 30px; color: white"><%= user.getNickname() %></span>
                </li>
                <li style="padding-right: 10px">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#modify" style="margin-top: 7px">
                        修改
                    </button>
                </li>
                <li style="padding-right: 50px">
                    <button class="btn btn-primary" data-toggle="modal" style="margin-top: 7px">
                        <a href="${pageContext.request.contextPath}/logout" style="color: white; text-decoration:none;">注销</a>
                    </button>
                </li>
            </ul>
            <% } %>
        </div>
    </nav>
</div>
<% if (user == null) { %>
<%@ include file="jsp/user/login.jsp" %>
<%@ include file="jsp/user/register.jsp" %>
<% } else { %>
<%@ include file="jsp/user/modify.jsp" %>
<% } %>