<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/7
  Time: 11:36
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
    <title>简历的编写</title>
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            var state = '<%=request.getAttribute("noResume")%>';
            if (state == 'noResume') {
                alert("你还没有编写简历");
            }
            else{
                alert("你已编写简历");
            }
            var success = '<%=request.getAttribute("success")%>'
            var error = '<%=request.getAttribute("error")%>'
            if(success == 'success'){
                alert("你的简历已经编写成功")
            }
            else if(error == 'error'){
                alert("简历已近变写，若想修改，请找修改按钮")
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
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/haveNoStuResumeServlet">我的简历</a>
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
<h3 style="text-align: center;">请制作您的简历</h3>
<div style="width: 1000px;margin: 0px auto;display: table;">
    <form role="form" action="${pageContext.request.contextPath}/writeStuResumeServler" method="post">
        <div class="form-group">
            <label for="Sno">学号</label>
            <input type="text" name="rsno" value="${user.ssno}" readonly class="form-control" id="Sno" maxlength="11">
        </div>
        <div class="form-group">
            <label for="Sname">姓名</label>
            <input type="text" name="rname" value="${user.sname}" readonly class="form-control" id="Sname1" maxlength="10">
        </div>
        <label for="Ssex">性别</label>
        <div class="form-group">
            <select class="form-control" name="rsex">
                <c:if test="${resume.rsex == '男' ||  empty resume.rsex}">
                    <option selected>男</option>
                    <option>女</option>
                </c:if>
                <c:if test="${resume.rsex == '女'}">
                    <option>男</option>
                    <option selected>女</option>
                </c:if>
            </select>
        </div>
        <div class="form-group">
            <label for="Snation">民族</label>
            <input type="text" name="rnation" value="${resume.rnation}" class="form-control" id="Snation" maxlength="6">
        </div>
        <div class="form-group">
            <!--<label for="Sbirthday">生日</label>-->
            <label for="meeting">生日：</label><input name="rbirthday" id="meeting" type="date" value="${resume.rbirthday}"/>
            <!--<input type="text" class="form-control" id="Sbirthday" >-->
        </div>
        <div class="form-group">
            <label for="Shome">籍贯</label>
            <input name="rcity" value="${resume.rcity}"  type="text" class="form-control" id="Shome" maxlength="30">
        </div>
        <div class="form-group">
            <label for="Sidentity">政治面貌</label>
            <select name="rpolitics" class="form-control">
                <option>群众</option>
                <option>共青团员</option>
                <option>中共党员</option>
                <option>预备党员</option>
            </select>
        </div>
        <div class="form-group">
            <label for="Sname">健康状况</label>
            <input type="text" name="rhealth" value="${resume.rhealth}"  class="form-control" id="Sname" maxlength="50">
        </div>
        <div class="form-group">
            <label for="Sschool">就读学校</label>
            <input type="text" name="rschool" value="${resume.rschool}" class="form-control" id="Sschool" maxlength="15">
        </div>
        <div class="form-group">
            <label for="Sedu">学历</label>
            <input type="text" name="reducation" value="${resume.reducation}" class="form-control" id="Sedu" maxlength="10">
        </div>
        <div class="form-group">
            <label for="Smajor">专业</label>
            <input type="text" name="rmajor" value="${resume.rmajor}" class="form-control" id="Smajor" maxlength="15">
        </div>
        <div class="form-group">
            <label for="SGtime">毕业时间：</label>
            <input id="SGtime" name="rgraduationtime" type="date" value="${resume.rgraduationtime}"/>
        </div>
        <div class="form-group">
            <label for="Semail">联系方式</label>
            <input type="text" name="rcontact" value="${resume.rcontact}" class="form-control" id="Sphone" maxlength="11">
        </div>
        <div class="form-group">
            <label for="Semail">电子邮件</label>
            <input type="email" name="remail" value="${resume.remail}" class="form-control" id="Semail" maxlength="20">
        </div>
        <div class="form-group">
            <label for="Scourse">主修课程</label>
            <input type="text" name="rcourse"  value="${resume.rcourse}" class="form-control" id="Scourse" maxlength="30">
        </div>
        <div class="form-group">
            <label for="Sprize">获得证书</label>
            <input type="text" name="rcredential"  value="${resume.rcredential}" class="form-control" id="Sprize" maxlength="50">
        </div>
        <div class="form-group">
            <label for="Seval">自我评价</label>
            <textarea rows="5" name="revaluation"  value="" style="width: 100%" maxlength="500">${resume.revaluation}</textarea>
            <!--<input type="text" class="form-control" id="Seval" >-->
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" id="regText"> 确认无误</label>
        </div>
        <button type="submit" class="btn btn-primary" id="regBtn" disabled>提交</button>
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
