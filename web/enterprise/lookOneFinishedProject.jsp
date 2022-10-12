<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/11
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>项目下载</title>
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
            <a class="nav-item nav-link "
               href="${pageContext.request.contextPath}/examineStuResumeServlet">审核简历</a>
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/lookFinishedServlet">查看完成项目</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/evaluateStudentServlet">评价完成项目</a>
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
<h3 style="font-weight: 700;text-align: center;margin-top: 15px;">${fileDownload.pname}-项目信息</h3>
<div style="" class="container">

    <div style="width: 50%;float: left" class="container">
        <table class="table">
            <tr>
                <td>项目发布时间:</td>
                <td>${fileDownload.publishtime}</td>
            </tr>
            <tr>
                <td>项目提交时间:</td>
                <td>${fileDownload.submittime}</td>
            </tr>
            <tr>
                <td>学号:</td>
                <td>${fileDownload.stuResumes.rsno}</td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td>${fileDownload.stuResumes.rname}</td>
            </tr>
            <tr>
                <td>学历:</td>
                <td>${fileDownload.stuResumes.reducation}</td>
            </tr>
            <tr>
                <td>专业:</td>
                <td>${fileDownload.stuResumes.rmajor}</td>
            </tr>
            <tr>
                <td>电话:</td>
                <td>${fileDownload.stuResumes.rcontact}</td>
            </tr>
            <tr>
                <td>电子邮件:</td>
                <td>${fileDownload.stuResumes.remail}</td>
            </tr>
            <tr>
                <td>毕业学校:</td>
                <td>${fileDownload.stuResumes.rschool}</td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
    <div style="width: 50%;float: left;" class="container">
        <table class="table">
            <tr>
                <td>项目描述:</td>
            </tr>
            <tr>
                <td colspan="3">
                    <textarea name="MainCourse" id="MainCourse" cols="50"
                              rows="5">${fileDownload.discription}</textarea>
                </td>
            </tr>
            <tr>

                <td>请下载学生完成项目(${fileDownload.file_name})</td>
            </tr>
            <tr>
                <td colspan="3">
                    <%--file_path=${fileDownload.file_path}&--%>
                    <a href="${pageContext.request.contextPath}/downLoadFileServlet?file_name=${fileDownload.file_name}">下载</a>
                </td>
            </tr>
        </table>
        <div style="width: 100%; margin-top: 100px; display: table;">
            <button type="button" class="btn btn-primary" onclick="javascript:history.back(-1);">返回</button>
        </div>
    </div>

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
