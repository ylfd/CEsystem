<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/11
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>评价学生项目完成情况</title>
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
            <a class="nav-item nav-link "
               href="${pageContext.request.contextPath}/enterprise/enterpriseIndex.jsp">首页<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link"
               href="${pageContext.request.contextPath}/enterprise/publishProject.jsp">发布项目</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/examineStuResumeServlet">审核简历</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/lookFinishedServlet">查看完成项目</a>
            <a class="nav-item nav-link active"
               href="${pageContext.request.contextPath}/evaluateStudentServlet">评价完成项目</a>
            <%--<button type="button" class="btn btn-primary" style="position: relative;left:190%;">登录</button>--%>
        </div>
    </div>
    <div class="dropdown" style="padding-right: 4%">
        <img style="height: 36px" src="enterprise/image/enterpriseImg.jpg">
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${user.ename}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="${pageContext.request.contextPath}/returnSelf_EnterpriseInfoServlet?eid=${user.eid}">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<div class="container" style="margin-top: 20px;">
    <table class="table table-striped">
        <legend style="text-align: center;">企业评价学生项目完成情况</legend>
        <thead>
        <tr>
            <th>项目名称</th>
            <th>项目提交时间</th>
            <th>项目发布时间</th>
            <th>学生学号</th>
            <th>学生姓名</th>
            <th>学生学校</th>
            <th>专业</th>
            <th colspan="2" style="text-align: center;">项目评价</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="t" varStatus="s">
            <tr>
                <td>${t.pname}</td>
                <td>${t.publishtime}</td>
                <td>${t.submittime}</td>
                <td>${t.stuResumes.rsno}</td>
                <td>${t.stuResumes.rname}</td>
                <td>${t.stuResumes.rschool}</td>
                <td>${t.stuResumes.rmajor}</td>
                <form action="${pageContext.request.contextPath}/saveStuGradeServlet" method="post">
                    <td colspan="2">
                        <div style="text-align: center;">
                            <input type="text" name="ps_id" value="${t.id}" hidden>
                            <input type="text" name="grade"  placeholder="满分100，请打分" value="${t.evaluate}" style="width: 150px;">
                        </div>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-primary btn-sm">保存</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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