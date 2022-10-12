<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/13
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>修改信息</title>
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            var success = '<%=request.getAttribute("success")%>';
            if (success == 'success') {
                alert("修改成功");
            }
        }
        $(function () {
            var regBtn = $("#regBtn");
            $("#regText").change(function () {
                var that = $(this);
                that.prop("checked", that.prop("checked"));
                if (that.prop("checked")) {
                    regBtn.prop("disabled", false)
                } else {
                    regBtn.prop("disabled", true)
                }
            });
        });
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
            <a class="nav-item nav-link " href="${pageContext.request.contextPath}/Stu/studentIndex.jsp">首页<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link"
               href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=1&rows=10">企业项目</a>
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
            <li><a href="${pageContext.request.contextPath}/returnSelf_StuInfoServlet?sid=${user.sid}" target="_blank">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<h3 style="text-align: center;">修改个人信息</h3>
<div style="width: 1000px;margin: 0px auto;display: table;">
    <form role="form" action="${pageContext.request.contextPath}/changeSelf_StuInfoServlet" method="post">
        <div class="form-group">
            <label for="Sno">学号</label>
            <input type="text" name="sid" value="${stu.sid}" hidden>
            <input type="text" name="ssno" value="${stu.ssno}" readonly class="form-control" id="Sno" maxlength="11">
        </div>
        <div class="form-group">
            <label for="Sname">姓名</label>
            <input type="text" name="sname" value="${stu.sname}" class="form-control" id="Sname" maxlength="10">
        </div>
        <div class="form-group">
            <label for="Snumber">账号</label>
            <input type="text" name="snumber" value="${stu.snumber}" class="form-control" maxlength="10">
        </div>
        <div class="form-group">
            <label for="Spassword">密码</label>
            <input type="text" name="spassword" value="${stu.spassword}" class="form-control" maxlength="10">
        </div>
        <label for="Ssex">性别</label>
        <div class="form-group">
            <select class="form-control" name="ssex">
                <c:if test="${stu.ssex == '男' ||  empty stu.ssex}">
                    <option selected>男</option>
                    <option>女</option>
                </c:if>
                <c:if test="${stu.ssex == '女'}">
                    <option>男</option>
                    <option selected>女</option>
                </c:if>
            </select>
        </div>
        <div class="form-group">
            <label for="Smajor">名族</label>
            <input type="text" name="snation" value="${stu.snation}" class="form-control" maxlength="15">
        </div>
        <div class="form-group">
            <label for="Smajor">学校</label>
            <input type="text" name="sschool" value="${stu.sschool}" class="form-control" maxlength="15">
        </div>
        <div class="form-group">
            <label for="Smajor">学院</label>
            <input type="text" name="scollege" value="${stu.scollege}" class="form-control" maxlength="15">
        </div>
        <div class="form-group">
            <label for="Smajor">专业</label>
            <input type="text" name="smajor" value="${stu.smajor}" class="form-control" maxlength="15">
        </div>
        <div class="form-group">
            <label for="Semail">联系方式</label>
            <input type="text" name="sphone" value="${stu.sphone}" class="form-control" id="Sphone" maxlength="11">
        </div>

        <div class="checkbox">
            <label>
                <input type="checkbox" id="regText"> 确认无误</label>
        </div>
        <button type="submit" class="btn btn-primary" id="regBtn" disabled>修改</button>
        <%--<button type="button" class="btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/changeStuInfoListServlet'">返回</button>--%>
        <%--<button type="button" class="btn btn-primary" onclick="javascript:history.back(-1);">返回</button>--%>
    </form>
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
