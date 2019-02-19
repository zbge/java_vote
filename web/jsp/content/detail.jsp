<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/16
  Time: 15:16
  Description: 详情信息投票页
--%>

<%@ page import="com.vote.jdbc.domain.Problem" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vote.jdbc.domain.Answer" %>
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
    <%@ include file="../../nav.jsp"%>
</header>
<div class="container">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="panel-title text-center">
                    <strong class="text-primary" style="font-size: 20px;">${pageContext.request.getAttribute("title")}</strong>
                </div>
                <div class="text-center" style="font-size: 16px">
                    <span class="glyphicon glyphicon-user"></span>&nbsp; ${pageContext.request.getAttribute("user")}
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span class="glyphicon glyphicon-time"></span>&nbsp;
                    ${pageContext.request.getAttribute("start_time")} &nbsp; —— &nbsp; ${pageContext.request.getAttribute("end_time")}
                </div>
            </div>
            <div class="panel-body" style="text-align: center">
                <span>${pageContext.request.getAttribute("content")}</span><br><hr>
                <form action="${pageContext.request.contextPath}/result" method="post">
                    <input class="hidden" name="vote" value="${vote}">
                <%
                    List<Problem> problems = (List) request.getAttribute("problems");
                    int cnt = 1;
                    int state = (int) request.getAttribute("state");
                    for (Problem problem: problems) {
                %>
                <p><% out.println(cnt++); %>、<%=problem.getContent()%></p>
                    <ul class="list-group">
                    <%
                        for (Answer answer: problem.getAnswers()) {
                        if (state == 2) {
                    %>
                        <div class="radio list-group-item text-left" style="width: 50%; margin-left: 25%">
                            <label>
                                <input type="radio" name="problem<%= problem.getId() %>" value="<%= answer.getId() %>"><%= answer.getOption() %>
                            </label>
                        </div>
                        <% } else if (state == 3) {%>
                        <li class="list-group-item text-left" style="width: 50%; margin-left: 25%">
                            <%= answer.getOption() %>
                            <span class="label label-info pull-right" style="font-size: 15px">
                                <strong><%= answer.getCount() %>&nbsp;票</strong>
                            </span>
                        </li>
                        <% } } %><br><% } %>
                    </ul><br>
                    <button type="submit" class="btn btn-primary" ${button}>提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
<footer>
    <span>技术支持：木杉 &nbsp; &nbsp; &nbsp; · &nbsp; &nbsp; &nbsp; © Copyright &nbsp; &nbsp; &nbsp;  版权所有，保留一切权力 &nbsp; &nbsp; &nbsp; · &nbsp; &nbsp; &nbsp; 基于 JavaWeb 构建</span>
</footer>
</body>
</html>
