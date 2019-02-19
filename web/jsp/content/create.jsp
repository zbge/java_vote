<%--
  Created by IntelliJ IDEA.
  Author: mushan
  Date: 2018/12/17
  Time: 9:51
  Description: 创建一个投票
--%>

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
                    <strong class="text-primary" style="font-size: 20px;">请填写以下相关内容</strong>
                    <span style="color: red">（带有*的为必填项）</span>
                </div>
            </div>
            <div class="panel-body" style="text-align: center">
                <form action="${pageContext.request.contextPath}/create" method="post" role="form" class="form-horizontal">
                    <div class="form-group">
                        <label for="title" class="col-md-1 control-label">*标题:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="title" name="title" value="${title}" placeholder="最多50个字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="content" class="col-md-1 control-label">*描述:</label>
                        <div class="col-md-11">
                            <textarea class="form-control" rows="5" id="content" name="content">${content}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="problem1" class="col-md-1 control-label">*问题1:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="problem1" name="problem1" value="${problem1}" placeholder="最多可填写50个字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer1_1" class="col-md-1 control-label">*答案1:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer1_1" name="answer1_1" value="${answer1_1}" placeholder="最多可填写50个字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer1_2" class="col-md-1 control-label">*答案2:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer1_2" name="answer1_2" value="${answer1_2}" placeholder="最多可填写50个字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer1_3" class="col-md-1 control-label">答案3:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer1_3" name="answer1_3" value="${answer1_3}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer1_4" class="col-md-1 control-label">答案4:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer1_4" name="answer1_4" value="${answer1_4}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer1_5" class="col-md-1 control-label">答案5:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer1_5" name="answer1_5" value="${answer1_5}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="problem2" class="col-md-1 control-label">问题2:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="problem2" name="problem2" value="${problem2}" placeholder="若没有那么多问题，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer2_1" class="col-md-1 control-label">答案1:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer2_1" name="answer2_1" value="${answer2_1}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer2_2" class="col-md-1 control-label">答案2:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer2_2" name="answer2_2" value="${answer2_2}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer2_3" class="col-md-1 control-label">答案3:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer2_3" name="answer2_3" value="${answer2_3}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer2_4" class="col-md-1 control-label">答案4:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer2_4" name="answer2_4" value="${answer2_4}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer2_5" class="col-md-1 control-label">答案5:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer2_5" name="answer2_5" value="${answer2_5}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="problem3" class="col-md-1 control-label">问题3:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="problem3" name="problem3" value="${problem3}" placeholder="若没有那么多问题，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer3_1" class="col-md-1 control-label">答案1:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer3_1" name="answer3_1" value="${answer3_1}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer3_2" class="col-md-1 control-label">答案2:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer3_2" name="answer3_2" value="${answer3_2}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer3_3" class="col-md-1 control-label">答案3:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer3_3" name="answer3_3" value="${answer3_3}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer3_4" class="col-md-1 control-label">答案4:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer3_4" name="answer3_4" value="${answer3_4}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer3_5" class="col-md-1 control-label">答案5:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer3_5" name="answer3_5" value="${answer3_5}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="problem4" class="col-md-1 control-label">问题4:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="problem4" name="problem4" value="${problem4}" placeholder="若没有那么多问题，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer4_1" class="col-md-1 control-label">答案1:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer4_1" name="answer4_1" value="${answer4_1}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer4_2" class="col-md-1 control-label">答案2:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer4_2" name="answer4_2" value="${answer4_2}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer4_3" class="col-md-1 control-label">答案3:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer4_3" name="answer4_3" value="${answer4_3}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer4_4" class="col-md-1 control-label">答案4:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer4_4" name="answer4_4" value="${answer4_4}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer4_5" class="col-md-1 control-label">答案5:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer4_5" name="answer4_5" value="${answer4_5}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="problem5" class="col-md-1 control-label">问题5:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="problem5" name="problem5" value="${problem5}" placeholder="若没有那么多问题，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer5_1" class="col-md-1 control-label">答案1:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer5_1" name="answer5_1" value="${answer5_1}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer5_2" class="col-md-1 control-label">答案2:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer5_2" name="answer5_2" value="${answer5_2}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer5_3" class="col-md-1 control-label">答案3:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer5_3" name="answer5_3" value="${answer5_3}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer5_4" class="col-md-1 control-label">答案4:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer5_4" name="answer5_4" value="${answer5_4}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer5_5" class="col-md-1 control-label">答案5:</label>
                        <div class="col-md-11">
                            <input type="text" class="form-control" id="answer5_5" name="answer5_5" value="${answer5_5}" placeholder="若没有那么多选项，该项可不填写。最多填写50字">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <label for="start_time" class="col-md-3 control-label">*开始投票时间：</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="start_time" name="start_time" value="${start_time}" placeholder="yyyy-MM-dd HH:mm">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="end_time" class="col-md-3 control-label">*结束投票时间：</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="end_time" name="end_time" value="${end_time}" placeholder="yyyy-MM-dd HH:mm">
                            </div>
                        </div>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">提交</button>
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

