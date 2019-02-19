<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/7
  Time: 15:50
  Description: 投票网站首页
--%>

<%@ page import="com.vote.jdbc.domain.Content" %>
<%@ page import="com.vote.jdbc.dao.ContentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vote.jdbc.dao.UsersDao" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="zh">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>木杉投票</title>
    <link rel="icon" href="${pageContext.request.contextPath}/static/image/icon.png" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <style>
      html {
        position: relative;
        min-height: 100%;
      }
      body {
        padding-top: 70px;
        padding-bottom: 50px;
      }
      footer {
        position: absolute;
        bottom: 0;
        width: 100%;
        background: rgb(16, 16, 16);
        font-size: 13px;
        text-align: center;
        color: #9d9d9d;
        padding-top: 14px;
        padding-bottom: 14px;
        border-top: 3px solid #337ab7;
      }
    </style>
  </head>
  <body>
    <header>
      <%@ include file="nav.jsp"%>
    </header>
    <div class="container">
      <div class="row">
        <%
          response.setCharacterEncoding("UTF-8");
          UsersDao usersDao = new UsersDao();
          ContentDao contentDao = new ContentDao();
          List<Content> contents = contentDao.findAll();
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
          Date now_date = new Date();
          User u = (User) session.getAttribute("user");
          if (u != null) {
              out.print("<div class=\"col-md-9\">");
          }
          String time = request.getParameter("time");
          for (Content content: contents) {
              int state;
              if (content.getStartTime().getTime() - now_date.getTime() > 0)
                  state = 1;
              else if (content.getEndTime().getTime() - now_date.getTime() > 0)
                  state = 2;
              else
                  state = 3;
              if (time != null) {
                  if ((time.equals("not_start") && (state == 2 || state == 3)) ||
                          (time.equals("starting") && (state == 1 || state == 3)) ||
                          (time.equals("end") && (state == 1 || state == 2)))
                      continue;
              }
        %>
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">
                <a href="${pageContext.request.contextPath}/detail?vote=<%=content.getId()%>"><strong class="text-success"><%= content.getTitle()%></strong></a>
                <span class="label label-info pull-right" style="font-size: 15px">
                  发起人：<%= usersDao.find(content.getUser()) %>
                </span>
              </h3>
            </div>
            <div class="panel-body">
              <%
                  if (state == 1)
                      out.print("<span class=\"label label-warning pull-right\" style=\"font-size: 15px\">未开始</span>");
                  else if (state == 2)
                      out.print("<span class=\"label label-success pull-right\" style=\"font-size: 15px\">正在进行</span>");
                  else if (state == 3)
                      out.print("<span class=\"label label-default pull-right\" style=\"font-size: 15px\">已结束</span>");
              %>
              <span style="font-size: 15px;"><strong>
                  日期：<%= simpleDateFormat.format(content.getStartTime()) %> —— <%= simpleDateFormat.format(content.getEndTime()) %>
              </strong></span><hr>
              <p><%= content.getContent()%></p>
            </div>
            <div class="panel-footer">
              <a class="btn" href="${pageContext.request.contextPath}/detail?vote=<%=content.getId()%>">进入投票 »</a>
              <span class="pull-right" style="font-size: 18px">已有 <%= content.getNumber() %> 人进行了投票</span>
            </div>
          </div>
        <% } if (u != null) { %>
        </div>
        <div class="col-md-3">
          <div class="panel panel-info" data-spy="affix" data-offset-top="100" style="width: 280px">
            <div class="panel-heading">
              <strong class="panel-title">与我相关</strong>
            </div>
            <div class="panel-body">
              <ul class="nav nav-tabs nav-stacked">
                <li><a href="${pageContext.request.contextPath}/create">创建投票</a></li>
                <li><a href="${pageContext.request.contextPath}/edit">修改投票</a></li>
                <li><a href="${pageContext.request.contextPath}/edit?time=not_start" style="margin-left: 20%; color: red">未开始</a></li>
                <li><a href="${pageContext.request.contextPath}/edit?time=starting" style="margin-left: 20%; color: red">正在进行</a></li>
                <li><a href="${pageContext.request.contextPath}/edit?time=end" style="margin-left: 20%; color: red">已结束</a></li>
              </ul>
            </div>
          </div>
        </div>
        <% } %>
        </div>
    </div>
    <footer>
      <span>技术支持：木杉 &nbsp; &nbsp; &nbsp; · &nbsp; &nbsp; &nbsp; © Copyright &nbsp; &nbsp; &nbsp;  版权所有，保留一切权力 &nbsp; &nbsp; &nbsp; · &nbsp; &nbsp; &nbsp; 基于 JavaWeb 构建</span>
    </footer>
  </body>
</html>
