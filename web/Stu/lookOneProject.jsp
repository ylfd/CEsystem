<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/5
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>项目详情</title>
    <style>
        .form-group {
            margin-top: 10px;
        }
    </style>
    <script type="text/javascript">
        function submitComfirm() {
            if(window.confirm("确认提交简历吗？")){
                return true;
            }
            return false;
        }
        window.onload = function () {
            var sendError = '<%=request.getAttribute("sendError")%>';
            if (sendError == 'sendError') {
                alert("你还没有写简历，请您先到写简历页面");
            }
            var sendSuccess = '<%=request.getAttribute("sendSuccess")%>';
            if (sendSuccess == 'sendSuccess') {
                alert("简历投递成功，请耐心等待");
            }

        }
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">协同育人校企合作平台</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link " href="${pageContext.request.contextPath}/Stu/studentIndex.jsp">首页<span
                    class="sr-only">(current)</span></a>
            <a class="nav-item nav-link active"
               href="${pageContext.request.contextPath}/showAllProjectStu_servlet">企业项目</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/ifEmployedListServlet">项目处理</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/haveNoStuResumeServlet">我的简历</a>
        </div>
    </div>
    <div class="dropdown" style="padding-right: 4%">
        <c:if test="${user.ssex == '男' || empty uesr.ssex}">
            <img style="height: 30px" src="Stu/image/boy.jpeg">
        </c:if>
        <c:if test="${user.ssex == '女'}">
            <img style="height: 30px" src="Stu/image/girl.jpg">
        </c:if>
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${user.sname}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="${pageContext.request.contextPath}/returnSelf_StuInfoServlet?sid=${user.sid}">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<h3 style="margin: 0px auto;display: table;font-weight: 700;">项目的详情信息</h3>
<form class="form-inline" style="margin: 0px auto;display: table;margin-top: 30px;">
    <div class="form-group">
        <label for="exampleCName">项目企业:</label>
        <%--<input type="text" name="id" hidden value="${project.id}" style="width: 300px">--%>
        <input type="text" name="company" value="${project.company}" style="width: 300px">
    </div>
    <div class="form-group">
        <label for="examplePName">项目名称:</label>
        <input type="text" id="PName" value="${project.name}" style="width: 300px">
    </div>
    <div class="form-group">
        <label for="examplePTechnology">项目技术:</label>
        <textarea rows="2" style="width: 300px">${project.requirement}</textarea>
    </div>
    <div class="form-group">
        <label for="name">项目详情:</label>
        <textarea class="form-control" rows="10" style="width: 300px">${project.content}</textarea>
    </div>
    <div class="form-group">
        <label for="exampleTime">发布时间:</label>
        <input type="text" id="Time" value="${project.publishtime}" style="width: 300px">
    </div>
</form>
<div style="margin: 0px auto;display: table;margin-top: 30px;">
    <button type="button" class="btn btn-primary"
            onclick="window.location.href = '${pageContext.request.contextPath}/sendStuResumeServlet?id=${project.id}&name=${project.name}&company=${project.company}'">
        投递简历
    </button>
    <div style="width: 200px;display: inline-block;"></div>
    <button type="button" class="btn btn-primary" onclick="javascript:history.back(-1);">返回</button>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
